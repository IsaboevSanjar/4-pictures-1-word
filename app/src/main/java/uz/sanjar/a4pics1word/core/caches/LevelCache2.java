package uz.sanjar.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class LevelCache2 {
    private static LevelCache2 cache;
    private final String KEY_LEVEL = "key_level";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private LevelCache2(Context context) {
        preferences = context.getSharedPreferences("game_level_cache2", Context.MODE_PRIVATE);
    }

    public static void init2(Context context) {
        if (cache == null) {
            cache = new LevelCache2(context);
        }
    }

    public static LevelCache2 getLevelCache() {
        return cache;
    }

    public int getLastLevel() {
        return preferences.getInt(KEY_LEVEL, 0);
    }

    public void setLastLevel(int level) {
        editor = preferences.edit();
        editor.putInt(KEY_LEVEL, level - 1).apply();
    }

    public void clear() {
        editor = preferences.edit();
        editor.clear().apply();
    }
};

