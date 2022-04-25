package uz.sanjar.a4pics1word.core.app;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import uz.sanjar.a4pics1word.core.caches.LevelCache1;
import uz.sanjar.a4pics1word.core.caches.LevelCache2;
import uz.sanjar.a4pics1word.core.caches.LevelCache3;
import uz.sanjar.a4pics1word.core.caches.LevelCache4;
import uz.sanjar.a4pics1word.core.caches.MaxScoreCache;
import uz.sanjar.a4pics1word.core.caches.ScoreCache1;
import uz.sanjar.a4pics1word.core.caches.ScoreCache2;
import uz.sanjar.a4pics1word.core.caches.ScoreCache3;
import uz.sanjar.a4pics1word.core.caches.ScoreCache4;
import uz.sanjar.a4pics1word.mainCache.HelpButtonClicked;
import uz.sanjar.a4pics1word.mainCache.MemoryHelper2;
import uz.sanjar.a4pics1word.mainCache.MemoryHelper3;
import uz.sanjar.a4pics1word.mainCache.MemoryHelper4;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LevelCache1.init(this);
        ScoreCache1.initScore(this);
        MaxScoreCache.initMaxScore(this);
        LevelCache2.init2(this);
        ScoreCache2.initScore2(this);
        LevelCache3.init3(this);
        ScoreCache3.initScore3(this);
        LevelCache4.init4(this);
        ScoreCache4.initScore4(this);

        MemoryHelper2.init(this);
        MemoryHelper3.init(this);
        MemoryHelper4.init(this);
        HelpButtonClicked.init(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
