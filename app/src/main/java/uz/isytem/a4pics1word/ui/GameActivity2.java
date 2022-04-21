package uz.isytem.a4pics1word.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import uz.isytem.a4pics1word.R;
import uz.isytem.a4pics1word.core.caches.LevelCache2;
import uz.isytem.a4pics1word.core.caches.MaxScoreCache;
import uz.isytem.a4pics1word.core.caches.ScoreCache2;
import uz.isytem.a4pics1word.core.manager.DataLoader2;
import uz.isytem.a4pics1word.core.manager.GameManager2;
import uz.isytem.a4pics1word.core.model.TestData2;
import uz.isytem.a4pics1word.mainCache.HelpButtonClicked;
import uz.isytem.a4pics1word.mainCache.MemoryHelper3;

public class GameActivity2 extends AppCompatActivity {

    StringBuilder answerBuilder = new StringBuilder();
    private RelativeLayout imageGroup, variantGroup;
    private LinearLayout answerGroup, endLevel2;
    private TextView deltaView, scorePlus, trueAnswer, closeButton;
    private Button currentLevelView, totalScoreView;
    private LinearLayout clearAnswer, helpButton, linearLayout, helpAndCencel;

    private DataLoader2 dataLoader;
    private List<TestData2> data;

    private GameManager2 manager;

    private int countSign = 0;
    private int s;
    private Button l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        MemoryHelper3.getHelper().getLastMainLevel3();
        loadViews();
        loadData();
        loadActions();
        startGame();
    }

    private void startGame() {
        if (ScoreCache2.getScoreCache().getLastScore() == 1) {
            HelpButtonClicked.getHelpButtonClicked().setHelpButton(false);
            ScoreCache2.getScoreCache().setLastScore(0);
        }
        windowMain();
        clearView();
        if (manager.hasData()) {
            loadDataToView();
        } else {
            MemoryHelper3.getHelper().setLastMainLevel3(true);
            endLevel2.setVisibility(View.VISIBLE);
            answerGroup.setVisibility(View.GONE);
            variantGroup.setVisibility(View.GONE);
            helpAndCencel.setVisibility(View.GONE);
            windowMainEnd();
        }
    }

    private void windowMainEnd() {
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.splash_back));
        window.setNavigationBarColor(this.getResources().getColor(R.color.splash_back));
    }

    private void clearView() {
        linearLayout.setVisibility(View.GONE);
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button button = (Button) variantGroup.getChildAt(i);
            button.setVisibility(View.VISIBLE);
            button.setText("");
        }
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            Button button = (Button) answerGroup.getChildAt(i);
            button.setVisibility(View.GONE);
            button.setText("");
        }
        answerBuilder.delete(0, answerBuilder.length());
        countSign = 0;
        enableVariantButtons();
    }

    private void loadActions() {
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button button = (Button) variantGroup.getChildAt(i);
            button.setOnClickListener(this::onVariantClick);
        }
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            Button button = (Button) answerGroup.getChildAt(i);
            button.setOnClickListener(this::onAnswerClick);
        }
        clearAnswer.setOnClickListener(this::onClearButtonClick);
        deleteVariantButtons();
    }

    private void deleteVariantButtons() {
        helpButton.setOnClickListener(view -> {
            if (countSign == manager.getCurrentAnswerLength()) {
                Toast.makeText(GameActivity2.this, "There is no empty space!!!", Toast.LENGTH_SHORT).show();
            } else if (manager.getTotalScore() < 120) {
                Toast.makeText(GameActivity2.this, "You must have at least 120 scores", Toast.LENGTH_SHORT).show();
            } else {
                countSign++;
                for (int i = 0; i < manager.getCurrentAnswerLength(); i++) {
                    Button button = (Button) answerGroup.getChildAt(i);
                    String text = String.valueOf(button.getText());
                    if (text.isEmpty()) {
                        s = i;
                        l = button;
                        manager.getTotalScore();
                        HelpButtonClicked.getHelpButtonClicked().setHelpButton(true);
                        break;
                    }
                }
                for (int i = 0; i < variantGroup.getChildCount(); i++) {
                    Button button = (Button) variantGroup.getChildAt(i);
                    String text = (String) button.getText();
                    if (text.equalsIgnoreCase(String.valueOf(manager.getCurrentAnswer().charAt(s)))) {
                        l.setText(text);
                        button.setVisibility(View.INVISIBLE);
                        checkHelp();
                        break;
                    }

                }
            }
        });

    }

    private void checkHelp() {
        if (countSign == manager.getCurrentAnswerLength()) {
            for (int i = 0; i < answerGroup.getChildCount(); i++) {
                Button answer = (Button) answerGroup.getChildAt(i);
                String textAnswer = answer.getText().toString();
                if (!textAnswer.isEmpty()) {
                    answerBuilder.append(textAnswer);
                }
            }
            ScoreCache2.getScoreCache().setLastScore(1);
            Log.d("GameActivityTAG", "onVariantClick: " + answerBuilder.toString());
            checkHelpWin();
        }
    }

    private void checkHelpWin() {
        boolean isWin = manager.checkAnswer(answerBuilder.toString());
        if (isWin) {
            new CountDownTimer(500, 500) {
                public void onFinish() {
                    linearLayout.setVisibility(View.VISIBLE);
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startGame();
                        }
                    });
                    windowLayout();
                    String trues = answerBuilder.toString();
                    trueAnswer.setText(trues);
                    scorePlus.setText("+" + manager.getTotalScore());
                }

                public void onTick(long millisUntilFinished) {
                    answerGroup.setEnabled(false);
                    variantGroup.setEnabled(false);
                }
            }.start();
        } else {
            disableVariantButtons();
            loadIndicators();
            showSnackBar();
        }
    }


    private void onClearButtonClick(View view) {
        countSign = 0;
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            Button buttonAnswer = (Button) answerGroup.getChildAt(i);
            if (buttonAnswer.getVisibility() == View.VISIBLE && buttonAnswer.getText().toString().length() != 0) {
                String answerText = buttonAnswer.getText().toString();
                for (int j = 0; j < variantGroup.getChildCount(); j++) {
                    Button buttonVariant = (Button) variantGroup.getChildAt(j);
                    if (buttonVariant.getText().toString().equalsIgnoreCase(answerText) && buttonVariant.getVisibility() == View.INVISIBLE) {
                        buttonVariant.setVisibility(View.VISIBLE);
                        enableVariantButtons();
                        buttonAnswer.setText("");
                        break;
                    }
                }
            }
        }
    }

    public void onVariantClick(View view) {
        Button button = (Button) view;

        for (int k = 0; k < answerGroup.getChildCount(); k++) {
            Button answer = (Button) answerGroup.getChildAt(k);
            if (answer.getText().toString().isEmpty() && answer.getVisibility() != View.GONE) {
                answer.setText(button.getText());
                button.setVisibility(View.INVISIBLE);
                countSign++;
                button.setVisibility(View.INVISIBLE);
                break;
            }
        }
        if (countSign == manager.getCurrentAnswerLength()) {
            for (int i = 0; i < answerGroup.getChildCount(); i++) {
                Button answer = (Button) answerGroup.getChildAt(i);
                String textAnswer = answer.getText().toString();
                if (!textAnswer.isEmpty()) {
                    //                   userAnswer = userAnswer.concat(textAnswer);
                    answerBuilder.append(textAnswer);
                }
            }

            if (HelpButtonClicked.getHelpButtonClicked().getHelpButton()) {
                ScoreCache2.getScoreCache().setLastScore(1);
            }
            Log.d("GameActivityTAG", "onVariantClick: " + answerBuilder.toString());
            boolean isWin = manager.checkAnswer(answerBuilder.toString());

            if (isWin) {
                new CountDownTimer(500, 500) {
                    public void onFinish() {
                        linearLayout.setVisibility(View.VISIBLE);
                        closeButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startGame();
                            }
                        });
                        windowLayout();
                        String trues = answerBuilder.toString();
                        trueAnswer.setText(trues);
                        scorePlus.setText("+" + manager.getTotalScore());
                    }

                    public void onTick(long millisUntilFinished) {
                        answerGroup.setEnabled(false);
                        variantGroup.setEnabled(false);
                    }
                }.start();
            } else {
                disableVariantButtons();
                loadIndicators();
                showSnackBar();
            }
        }
    }

    private void disableVariantButtons() {
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button variant = (Button) variantGroup.getChildAt(i);
            variant.setEnabled(false);
            variant.setBackgroundResource(R.drawable.disable_button);
        }
    }

    private void enableVariantButtons() {
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button variant = (Button) variantGroup.getChildAt(i);
            variant.setEnabled(true);
            variant.setBackgroundResource(R.drawable.button_back);
        }
    }

    private void loadIndicators() {
        deltaView.setText("+" + manager.getCurrentScore());
    }

    public void onAnswerClick(View view) {
        enableVariantButtons();
        Button button = (Button) view;
        String answerText = button.getText().toString();
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button variant = (Button) variantGroup.getChildAt(i);
            if (answerText.equalsIgnoreCase(variant.getText().toString()) && variant.getVisibility() == View.INVISIBLE) {
                variant.setVisibility(View.VISIBLE);
                countSign--;
                answerBuilder.delete(0, answerBuilder.length());
                break;
            }
        }
        button.setText("");
    }

    private void loadDataToView() {
        ArrayList<Drawable> images = manager.getCurrentImage();
        for (int i = 0; i < images.size(); i++) {
            ImageView imageView = (ImageView) imageGroup.getChildAt(i);
            imageView.setImageDrawable(images.get(i));
        }
        currentLevelView.setText("" + manager.getCurrentLevel());
        totalScoreView.setText("Score: " + manager.getTotalScore());
        deltaView.setText("+" + manager.getCurrentScore());
        int totalVariantLength = manager.getCurrentAnswerLength();
        for (int i = 0; i < answerGroup.getChildCount(); i++) {
            Button button = (Button) answerGroup.getChildAt(i);
            if (i < totalVariantLength) {
                button.setVisibility(View.VISIBLE);
                button.setBackgroundResource(R.drawable.button_back);
            } else {
                button.setVisibility(View.GONE);
            }
            button.setText("");
        }
        String variantText = manager.getCurrentVariant();
        for (int i = 0; i < variantGroup.getChildCount(); i++) {
            Button button = (Button) variantGroup.getChildAt(i);
            button.setText(variantText.charAt(i) + "");
            button.setVisibility(View.VISIBLE);
            button.setBackgroundResource(R.drawable.button_back);
        }
    }

    private void loadData() {
        dataLoader = new DataLoader2(this);
        data = dataLoader.getRestData();
        manager = new GameManager2(data);
    }

    private void loadViews() {
        helpAndCencel = findViewById(R.id.bottom_clear_and_help);
        closeButton = findViewById(R.id.close_button);
        trueAnswer = findViewById(R.id.true_answer);
        scorePlus = findViewById(R.id.score_plus);
        linearLayout = findViewById(R.id.linear_layout);
        helpButton = findViewById(R.id.help_button);
        clearAnswer = findViewById(R.id.clear_answer);
        imageGroup = findViewById(R.id.image_group);
        variantGroup = findViewById(R.id.variant_group);
        answerGroup = findViewById(R.id.answer_group);
        currentLevelView = findViewById(R.id.current_level);
        totalScoreView = findViewById(R.id.total_score);
        deltaView = findViewById(R.id.delta_score);
        endLevel2 = findViewById(R.id.end_level2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LevelCache2.getLevelCache().setLastLevel(manager.getCurrentLevel());
        ScoreCache2.getScoreCache().setLastScore(manager.getTotalScore());
        MaxScoreCache.getMaxScoreCache().setLastMaxScore(manager.getCurrentScore());
    }

    public void windowLayout() {
        Window window = this.getWindow();
        window.setNavigationBarColor(this.getResources().getColor(R.color.layoutBack));
        window.setStatusBarColor(this.getResources().getColor(R.color.layoutBack));
    }

    public void windowMain() {
        Window window = this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.blue));
        window.setNavigationBarColor(this.getResources().getColor(R.color.blue));
    }

    public void showSnackBar() {
        Snackbar snackbar = Snackbar.make(imageGroup, "You made a mistake", Snackbar.LENGTH_SHORT);
        snackbar.setAction("Opps", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        snackbar.show();
    }

    /*public Drawable getImageFromAssets(String fileName) {

        Drawable drawable;

        try {
            // get input stream
            InputStream ims = getAssets().open("gameImages1/" + fileName);
            // load image as Drawable
            drawable = Drawable.createFromStream(ims, null);
            ims.close();
        } catch (IOException ex) {
            ex.fillInStackTrace();
            return null;
        }
        return drawable;
    }*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GameActivity2.this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}