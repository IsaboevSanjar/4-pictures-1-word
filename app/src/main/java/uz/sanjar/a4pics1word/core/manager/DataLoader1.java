package uz.sanjar.a4pics1word.core.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import uz.sanjar.a4pics1word.core.caches.LevelCache1;
import uz.sanjar.a4pics1word.core.caches.MaxScoreCache;
import uz.sanjar.a4pics1word.core.caches.ScoreCache1;
import uz.sanjar.a4pics1word.core.model.TestData1;

public class DataLoader1 {
    private final Context context;
    private int lastLevel;

    public DataLoader1(Context context) {
        this.context = context;
        LevelCache1.init(context);
        ScoreCache1.initScore(context);
        MaxScoreCache.initMaxScore(context);
        lastLevel = LevelCache1.getLevelCache().getLastLevel();
    }

    public List<TestData1> getRestData() {
        ArrayList<TestData1> allData = getAllData();
        return allData.subList(lastLevel, allData.size());
    }

    public ArrayList<TestData1> getAllData() {
        ArrayList<TestData1> data = new ArrayList<>();
        ArrayList<Drawable> images = new ArrayList<>();
        for (int i = 1; i <= 22; i++) {
            for (int j = 1; j <= 4; j++) {
                images.add(getImageFromAssets("image_" + i + "_" + j + ".webp"));
            }
        }

        TestData1 test1 = new TestData1(
                "citrus", "litmsorcnueg", 0
        );
        test1.addImage(images.get(0));
        test1.addImage(images.get(1));
        test1.addImage(images.get(2));
        test1.addImage(images.get(3));
        data.add(test1);

        TestData1 test2 = new TestData1(
                "crime", "sejcfrdimgea", 1
        );
        test2.addImage(images.get(4));
        test2.addImage(images.get(5));
        test2.addImage(images.get(6));
        test2.addImage(images.get(7));
        data.add(test2);
        TestData1 test3 = new TestData1(
                "banana", "ubranlainadi", 2
        );
        test3.addImage(images.get(8));
        test3.addImage(images.get(9));
        test3.addImage(images.get(10));
        test3.addImage(images.get(11));
        data.add(test3);
        TestData1 test4 = new TestData1(
                "heroes", "ethteraroves", 3
        );
        test4.addImage(images.get(12));
        test4.addImage(images.get(13));
        test4.addImage(images.get(14));
        test4.addImage(images.get(15));
        data.add(test4);
        TestData1 test5 = new TestData1(
                "dirty", "ditichrtnfoy", 4
        );
        test5.addImage(images.get(16));
        test5.addImage(images.get(17));
        test5.addImage(images.get(18));
        test5.addImage(images.get(19));
        data.add(test5);
        TestData1 test6 = new TestData1(
                "mother", "ibmobytahner", 5
        );
        test6.addImage(images.get(20));
        test6.addImage(images.get(21));
        test6.addImage(images.get(22));
        test6.addImage(images.get(23));
        data.add(test6);
        TestData1 test7 = new TestData1(
                "sweet", "csowaelchetl", 6
        );
        test7.addImage(images.get(24));
        test7.addImage(images.get(25));
        test7.addImage(images.get(26));
        test7.addImage(images.get(27));
        data.add(test7);
        TestData1 test8 = new TestData1(
                "island", "tooisclaannd", 7
        );
        test8.addImage(images.get(28));
        test8.addImage(images.get(29));
        test8.addImage(images.get(30));
        test8.addImage(images.get(31));
        data.add(test8);
        TestData1 test9 = new TestData1(
                "drink", "dmriilnkking", 8
        );
        test9.addImage(images.get(32));
        test9.addImage(images.get(33));
        test9.addImage(images.get(34));
        test9.addImage(images.get(35));
        data.add(test9);
        TestData1 test10 = new TestData1(
                "round", "croiurlencdd", 9
        );
        test10.addImage(images.get(36));
        test10.addImage(images.get(37));
        test10.addImage(images.get(38));
        test10.addImage(images.get(39));
        data.add(test10);
        TestData1 test11 = new TestData1(
                "beans", "tbsmearnshry", 10
        );
        test11.addImage(images.get(40));
        test11.addImage(images.get(41));
        test11.addImage(images.get(42));
        test11.addImage(images.get(43));
        data.add(test11);
        TestData1 test12 = new TestData1(
                "sign", "wdsiagranoyd", 11
        );
        test12.addImage(images.get(44));
        test12.addImage(images.get(45));
        test12.addImage(images.get(46));
        test12.addImage(images.get(47));
        data.add(test12);

        TestData1 test13 = new TestData1(
                "down", "rdoadowndedc", 12
        );
        test13.addImage(images.get(48));
        test13.addImage(images.get(49));
        test13.addImage(images.get(50));
        test13.addImage(images.get(51));
        data.add(test13);
        TestData1 test14 = new TestData1(
                "luck", "gluicrlrdakc", 13
        );
        test14.addImage(images.get(52));
        test14.addImage(images.get(53));
        test14.addImage(images.get(54));
        test14.addImage(images.get(55));
        data.add(test14);
        TestData1 test15 = new TestData1(
                "sink", "wsiantkergst", 14
        );
        test15.addImage(images.get(56));
        test15.addImage(images.get(57));
        test15.addImage(images.get(58));
        test15.addImage(images.get(59));
        data.add(test15);
        TestData1 test16 = new TestData1(
                "rock", "rosimucckgui", 15
        );
        test16.addImage(images.get(60));
        test16.addImage(images.get(61));
        test16.addImage(images.get(62));
        test16.addImage(images.get(63));
        data.add(test16);
        TestData1 test17 = new TestData1(
                "new", "pnaerwtyighn", 16
        );
        test17.addImage(images.get(64));
        test17.addImage(images.get(65));
        test17.addImage(images.get(66));
        test17.addImage(images.get(67));
        data.add(test17);
        TestData1 test18 = new TestData1(
                "pull", "pusbdfgunfll", 17
        );
        test18.addImage(images.get(68));
        test18.addImage(images.get(69));
        test18.addImage(images.get(70));
        test18.addImage(images.get(71));
        data.add(test18);
        TestData1 test19 = new TestData1(
                "cry", "dcadvdabersy", 18
        );
        test19.addImage(images.get(72));
        test19.addImage(images.get(73));
        test19.addImage(images.get(74));
        test19.addImage(images.get(75));
        data.add(test19);
        TestData1 test20 = new TestData1(
                "record", "rmuecsiorcdl", 19
        );
        test20.addImage(images.get(76));
        test20.addImage(images.get(77));
        test20.addImage(images.get(78));
        test20.addImage(images.get(79));
        data.add(test20);
        TestData1 test21 = new TestData1(
                "trunk", "eltreufnehkn", 20
        );
        test21.addImage(images.get(80));
        test21.addImage(images.get(81));
        test21.addImage(images.get(82));
        test21.addImage(images.get(83));
        data.add(test21);
        TestData1 test22 = new TestData1(
                "alarm", "ktialamermcl", 21
        );
        test22.addImage(images.get(84));
        test22.addImage(images.get(85));
        test22.addImage(images.get(86));
        test22.addImage(images.get(87));
        data.add(test22);
        return data;
    }

    public Drawable getImageFromAssets(String fileName) {
        Drawable drawable;
        try {
            // get input stream
            InputStream ims = context.getAssets().open("gameImages1/" + fileName);
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
