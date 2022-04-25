package uz.sanjar.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class MaxScoreCache {
    private static MaxScoreCache cache;
    private final String KEY_MAX_SCORE = "key_max_score";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private MaxScoreCache(Context context) {
        preferences = context.getSharedPreferences("game_max_score_cache", Context.MODE_PRIVATE);
    }

    public static void initMaxScore(Context context) {
        if (cache == null) {
            cache = new MaxScoreCache(context);
        }
    }

    public static MaxScoreCache getMaxScoreCache() {
        return cache;
    }

    public int getLastMaxScore() {
        return preferences.getInt(KEY_MAX_SCORE, 0);
    }

    public void setLastMaxScore(int score) {
        editor = preferences.edit();

        editor.putInt(KEY_MAX_SCORE, score).apply();
    }

    public void clear() {
        editor = preferences.edit();
        editor.clear().apply();
    }
}
