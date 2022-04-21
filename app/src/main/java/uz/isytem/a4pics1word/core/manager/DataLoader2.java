package uz.isytem.a4pics1word.core.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import uz.isytem.a4pics1word.core.caches.LevelCache2;
import uz.isytem.a4pics1word.core.caches.MaxScoreCache;
import uz.isytem.a4pics1word.core.caches.ScoreCache2;
import uz.isytem.a4pics1word.core.model.TestData2;

public class DataLoader2 {
    private final Context context;
    private int lastLevel;


    private List<TestData2> data;

    public DataLoader2(Context context) {
        this.context = context;
        LevelCache2.init2(context);
        ScoreCache2.initScore2(context);
        MaxScoreCache.initMaxScore(context);
        lastLevel = LevelCache2.getLevelCache().getLastLevel();
    }

    public void playAgain() {
        if (lastLevel == 0) {
            getRestData().clear();
            lastLevel = 0;
            Log.d("playAgainTAG", "playAgain: ");
        }
    }

    public List<TestData2> getRestData() {
        ArrayList<TestData2> allData = getAllData();
        return allData.subList(lastLevel, allData.size());
    }

    public ArrayList<TestData2> getAllData() {
        ArrayList<TestData2> data = new ArrayList<>();

        ArrayList<Drawable> images = new ArrayList<>();

        for (int i = 10; i <= 31; i++) {

            for (int j = 1; j <= 3; j++) {
                images.add(getImageFromAssets("image_" + i + "_" + j + ".webp"));
            }
        }
        TestData2 test1 = new TestData2(
                "diving", "ocsdiwvmimng", 0
        );
        test1.addImage(images.get(0));
        test1.addImage(images.get(1));
        test1.addImage(images.get(2));
        data.add(test1);

        TestData2 test2 = new TestData2(
                "quiet", "squlieetpsrt", 1
        );
        test2.addImage(images.get(3));
        test2.addImage(images.get(4));
        test2.addImage(images.get(5));
        data.add(test2);

        TestData2 test3 = new TestData2(
                "dry", "ogdyrrubymir", 2
        );
        test3.addImage(images.get(6));
        test3.addImage(images.get(7));
        test3.addImage(images.get(8));
        data.add(test3);

        TestData2 test4 = new TestData2(
                "old", "tomlideifhry", 3
        );
        test4.addImage(images.get(9));
        test4.addImage(images.get(10));
        test4.addImage(images.get(11));
        data.add(test4);
        TestData2 test5 = new TestData2(
                "pair", "hpsardioresb", 4
        );
        test5.addImage(images.get(12));
        test5.addImage(images.get(13));
        test5.addImage(images.get(14));
        data.add(test5);

        TestData2 test6 = new TestData2(
                "wine", "kgwlainsesdr", 5
        );
        test6.addImage(images.get(15));
        test6.addImage(images.get(16));
        test6.addImage(images.get(17));
        data.add(test6);
        TestData2 test7 = new TestData2(
                "bow", "tbarogetwrit", 6
        );
        test7.addImage(images.get(18));
        test7.addImage(images.get(19));
        test7.addImage(images.get(20));
        data.add(test7);
        TestData2 test8 = new TestData2(
                "pull", "sputstanlopl", 7
        );
        test8.addImage(images.get(21));
        test8.addImage(images.get(22));
        test8.addImage(images.get(23));
        data.add(test8);

        TestData2 test9 = new TestData2(
                "net", "intereglobet", 8
        );
        test9.addImage(images.get(24));
        test9.addImage(images.get(25));
        test9.addImage(images.get(26));
        data.add(test9);

        TestData2 test10 = new TestData2(
                "tear", "etevsebrarbr", 9
        );
        test10.addImage(images.get(27));
        test10.addImage(images.get(28));
        test10.addImage(images.get(29));
        data.add(test10);

        TestData2 test11 = new TestData2(
                "fun", "esufppuorntn", 10
        );
        test11.addImage(images.get(30));
        test11.addImage(images.get(31));
        test11.addImage(images.get(32));
        data.add(test11);

        TestData2 test12 = new TestData2(
                "trip", "ratverliresp", 11
        );
        test12.addImage(images.get(33));
        test12.addImage(images.get(34));
        test12.addImage(images.get(35));
        data.add(test12);

        TestData2 test13 = new TestData2(
                "chest", "cdhbedbtsdet", 12
        );
        test13.addImage(images.get(36));
        test13.addImage(images.get(37));
        test13.addImage(images.get(38));
        data.add(test13);

        TestData2 test14 = new TestData2(
                "tie", "fateitrebrwv", 13
        );
        test14.addImage(images.get(39));
        test14.addImage(images.get(40));
        test14.addImage(images.get(41));
        data.add(test14);

        TestData2 test15 = new TestData2(
                "mix", "cmoliorxpriu", 14
        );
        test15.addImage(images.get(42));
        test15.addImage(images.get(43));
        test15.addImage(images.get(44));
        data.add(test15);

        TestData2 test16 = new TestData2(
                "father", "cfialdtnhesr", 15
        );
        test16.addImage(images.get(45));
        test16.addImage(images.get(46));
        test16.addImage(images.get(47));
        data.add(test16);

        TestData2 test17 = new TestData2(
                "change", "tcdohlaarnge", 16
        );
        test17.addImage(images.get(48));
        test17.addImage(images.get(49));
        test17.addImage(images.get(50));
        data.add(test17);

        TestData2 test18 = new TestData2(
                "cold", "mcounotalnid", 17
        );
        test18.addImage(images.get(51));
        test18.addImage(images.get(52));
        test18.addImage(images.get(53));
        data.add(test18);

        TestData2 test19 = new TestData2(
                "pole", "pfaocslerdeg", 18
        );
        test19.addImage(images.get(54));
        test19.addImage(images.get(55));
        test19.addImage(images.get(56));
        data.add(test19);
        TestData2 test20 = new TestData2(
                "rope", "crfwovrtphoe", 19
        );
        test20.addImage(images.get(57));
        test20.addImage(images.get(58));
        test20.addImage(images.get(59));
        data.add(test20);
        TestData2 test21 = new TestData2(
                "code", "yrcxdoeaduve", 20
        );
        test21.addImage(images.get(60));
        test21.addImage(images.get(61));
        test21.addImage(images.get(62));
        data.add(test21);
        TestData2 test22 = new TestData2(
                "stink", "wfsotuinlkou", 21
        );
        test22.addImage(images.get(63));
        test22.addImage(images.get(64));
        test22.addImage(images.get(65));
        data.add(test22);

        return data;
    }

    public Drawable getImageFromAssets(String fileName) {
        Drawable drawable;
        try {
            // get input stream
            InputStream ims = context.getAssets().open("gameImages2/" + fileName);
            // load image as Drawable
            drawable = Drawable.createFromStream(ims, null);
            ims.close();
        } catch (IOException ex) {
            ex.fillInStackTrace();
            return null;
        }
        return drawable;
    }
}
