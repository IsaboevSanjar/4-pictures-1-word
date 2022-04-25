package uz.sanjar.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreCache3 {
    private static ScoreCache3 cache;
    private final String KEY_SCORE = "key_score3";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private ScoreCache3(Context context) {
        preferences = context.getSharedPreferences("game_score_cache3", Context.MODE_PRIVATE);
    }

    public static void initScore3(Context context) {
        if (cache == null) {
            cache = new ScoreCache3(context);
        }
    }

    public static ScoreCache3 getScoreCache() {
        return cache;
    }

    public int getLastScore() {
        return preferences.getInt(KEY_SCORE, 0);
    }

    public void setLastScore(int score) {
        editor = preferences.edit();
        editor.putInt(KEY_SCORE, score).apply();
    }

    public void clear() {
        editor = preferences.edit();
        editor.clear().apply();
    }
}
