package uz.sanjar.a4pics1word.mainCache;

import android.content.Context;
import android.content.SharedPreferences;

public class HelpButtonClicked {
    private SharedPreferences preferences;
    private static HelpButtonClicked helper;
    private HelpButtonClicked(Context context) {
        //context
        preferences = context.getSharedPreferences("help_button", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (helper == null) {
            helper = new HelpButtonClicked(context);
        }
    }

    public static HelpButtonClicked getHelpButtonClicked() {
        return helper;
    }

    public boolean getHelpButton() {
        return preferences.getBoolean("help", false);
    }

    public void setHelpButton(boolean b) {
        preferences.edit().putBoolean("help", b).apply();
    }
}
