package uz.isytem.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreCache2 {
    private static ScoreCache2 cache;
    private final String KEY_SCORE = "key_score2";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private ScoreCache2(Context context) {
        preferences = context.getSharedPreferences("game_score_cache2", Context.MODE_PRIVATE);
    }

    public static void initScore2(Context context) {
        if (cache == null) {
            cache = new ScoreCache2(context);
        }
    }

    public static ScoreCache2 getScoreCache() {
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
