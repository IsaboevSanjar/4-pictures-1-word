package uz.sanjar.a4pics1word.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import uz.sanjar.a4pics1word.R;

public class SplashScreenActivity extends AppCompatActivity {
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        timer = new CountDownTimer(2_000, 1_000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashScreenActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
        Window window = this.getWindow();
        window.setNavigationBarColor(this.getResources().getColor(R.color.splash_navigation));
        window.setStatusBarColor(this.getResources().getColor(R.color.splash_navigation));
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }
}