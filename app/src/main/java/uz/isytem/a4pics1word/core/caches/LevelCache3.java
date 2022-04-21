package uz.isytem.a4pics1word.core.caches;

import android.content.Context;
import android.content.SharedPreferences;

public class LevelCache3 {
    private static LevelCache3 cache;
    private final String KEY_LEVEL = "key_level";
    public SharedPreferences preferences;
    public SharedPreferences.Editor editor;

    private LevelCache3(Context context) {
        preferences = context.getSharedPreferences("game_level_cache3", Context.MODE_PRIVATE);
    }

    public static void init3(Context context) {
        if (cache == null) {
            cache = new LevelCache3(context);
        }
    }

    public static LevelCache3 getLevelCache() {
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
}
