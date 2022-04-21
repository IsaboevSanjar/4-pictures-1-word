package uz.isytem.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreCache4 {
    private static ScoreCache4 cache;
    private final String KEY_SCORE = "key_score4";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private ScoreCache4(Context context) {
        preferences = context.getSharedPreferences("game_score_cache4", Context.MODE_PRIVATE);
    }

    public static void initScore4(Context context) {
        if (cache == null) {
            cache = new ScoreCache4(context);
        }
    }

    public static ScoreCache4 getScoreCache() {
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
