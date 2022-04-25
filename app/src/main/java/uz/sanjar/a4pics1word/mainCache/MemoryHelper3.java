package uz.sanjar.a4pics1word.mainCache;

import android.content.Context;
import android.content.SharedPreferences;

public class MemoryHelper3 {
    private static MemoryHelper3 helper;
    private SharedPreferences preferences;

    private MemoryHelper3(Context context) {
        //context
        preferences = context.getSharedPreferences("4pics1word3", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (helper == null) {
            helper = new MemoryHelper3(context);
        }
    }

    public static MemoryHelper3 getHelper() {
        return helper;
    }

    public boolean getLastMainLevel3() {
        return preferences.getBoolean("level_state3", false);
    }

    public void setLastMainLevel3(boolean b) {
        preferences.edit().putBoolean("level_state3", b).apply();
    }
}
