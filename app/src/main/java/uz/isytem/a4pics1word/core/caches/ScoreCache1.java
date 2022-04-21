package uz.isytem.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreCache1 {
    private static ScoreCache1 cache;
    private final String KEY_SCORE = "key_score";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private ScoreCache1(Context context) {
        preferences = context.getSharedPreferences("game_score_cache", Context.MODE_PRIVATE);
    }

    public static void initScore(Context context) {
        if (cache == null) {
            cache = new ScoreCache1(context);
        }
    }

    public static ScoreCache1 getScoreCache() {
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
