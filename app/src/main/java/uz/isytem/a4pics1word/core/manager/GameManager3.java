package uz.isytem.a4pics1word.core.manager;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import uz.isytem.a4pics1word.core.caches.LevelCache3;
import uz.isytem.a4pics1word.core.caches.MaxScoreCache;
import uz.isytem.a4pics1word.core.caches.ScoreCache3;
import uz.isytem.a4pics1word.core.model.TestData3;

public class GameManager3 {
    private final int MAX_SCORE = 40;
    private final int MIN_SCORE = 10;
    private final int DELTA_SCORE = 5;
    private int currentPosition = 0;
    private int currentLevel = 1;
    private int totalQuestion;
    private int totalTrues = 0;
    private List<TestData3> data;
    private int currentScore = MAX_SCORE;
    private int totalScore = 0;

    public GameManager3(List<TestData3> data) {
        this.data = data;
        totalQuestion = data.size();
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    private TestData3 getCurrentData() {
        return data.get(currentPosition);
    }

    public String getCurrentAnswer() {
        return getCurrentData().getAnswer();
    }

    public int getCurrentAnswerLength() {
        return getCurrentAnswer().length();
    }

    public String getCurrentVariant() {
        return getCurrentData().getVariant();
    }

    public ArrayList<Drawable> getCurrentImage() {
        return getCurrentData().getImages();
    }

    public int getCurrentScore() {
        return currentScore;/*MaxScoreCache.getMaxScoreCache().getLastMaxScore();*/
    }

    public int getMaxScore() {
        return MAX_SCORE - MaxScoreCache.getMaxScoreCache().getLastMaxScore();
    }


    public int getCurrentLevel() {
        return currentLevel + LevelCache3.getLevelCache().getLastLevel();
    }

    public boolean checkAnswer(String answer) {
        boolean isTrue = getCurrentAnswer().equalsIgnoreCase(answer);

        if (isTrue) {
            totalScore += currentScore;
            currentScore = MAX_SCORE;
            currentLevel++;
            totalTrues++;
            if (currentPosition + 1 < totalQuestion) {
                currentPosition++;
            }

        } else {
            if (currentScore > MIN_SCORE) {
                currentScore -= DELTA_SCORE;
            }
        }
        return isTrue;
    }

    public int getTotalScore() {
        int totally;
        if (ScoreCache3.getScoreCache().getLastScore() == 1) {
            totalScore = currentScore;
            totally = totalScore;
        } else {
            totally = totalScore + ScoreCache3.getScoreCache().getLastScore();
        }
        return totally;
    }


    public boolean hasData() {
        return currentLevel - 1 < data.size();
    }

    public boolean hasNoData() {
        return currentLevel - 1 >= data.size();
    }
}
