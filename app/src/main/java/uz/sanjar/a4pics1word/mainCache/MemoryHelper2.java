package uz.sanjar.a4pics1word.mainCache;

import android.content.Context;
import android.content.SharedPreferences;

public class MemoryHelper2 {
    private static MemoryHelper2 helper;
    private SharedPreferences preferences;

    private MemoryHelper2(Context context) {
        //context
        preferences = context.getSharedPreferences("4pics1word2", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (helper == null) {
            helper = new MemoryHelper2(context);
        }
    }

    public static MemoryHelper2 getHelper() {
        return helper;
    }

    public boolean getLastMainLevel12() {
        return preferences.getBoolean("level_state12", false);
    }

    public void setLastMainLevel12(boolean b) {
        preferences.edit().putBoolean("level_state12", b).apply();
    }

    /*private static SetUpHelper helper;
    private SharedPreferences preferences;
    private SetUpHelper(Context context){
        //context
        preferences=context.getSharedPreferences("note",Context.MODE_PRIVATE);
    }
    public static void init(Context context){
        if(helper==null){
            helper=new SetUpHelper(context);
        }
    }

    public static SetUpHelper getHelper() {
        return helper;
    }
    public void setBoard(boolean b) {
        preferences.edit().putBoolean("board",b).apply();
    }
    public boolean getBoard(){
        return preferences.getBoolean("board",false);
    }*/
}
