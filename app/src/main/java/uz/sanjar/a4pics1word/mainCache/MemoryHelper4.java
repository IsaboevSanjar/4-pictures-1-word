package uz.sanjar.a4pics1word.mainCache;

import android.content.Context;
import android.content.SharedPreferences;

public class MemoryHelper4 {
    private static MemoryHelper4 helper;
    private SharedPreferences preferences;

    private MemoryHelper4(Context context) {
        //context
        preferences = context.getSharedPreferences("4pics1word4", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (helper == null) {
            helper = new MemoryHelper4(context);
        }
    }

    public static MemoryHelper4 getHelper() {
        return helper;
    }

    public boolean getLastMainLevel4() {
        return preferences.getBoolean("level_state4", false);
    }

    public void setLastMainLevel4(boolean b) {
        preferences.edit().putBoolean("level_state4", b).apply();
    }
}
