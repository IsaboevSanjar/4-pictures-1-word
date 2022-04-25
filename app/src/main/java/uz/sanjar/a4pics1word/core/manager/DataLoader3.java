package uz.sanjar.a4pics1word.core.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import uz.sanjar.a4pics1word.core.caches.LevelCache3;
import uz.sanjar.a4pics1word.core.caches.MaxScoreCache;
import uz.sanjar.a4pics1word.core.caches.ScoreCache3;
import uz.sanjar.a4pics1word.core.model.TestData3;

public class DataLoader3 {
    private final Context context;
    private int lastLevel;
    private int lastScore;

    public DataLoader3(Context context) {
        this.context = context;
        LevelCache3.init3(context);
        ScoreCache3.initScore3(context);
        MaxScoreCache.initMaxScore(context);
        lastLevel = LevelCache3.getLevelCache().getLastLevel();
    }

    public List<TestData3> getRestData() {
        ArrayList<TestData3> allData = getAllData();
        return allData.subList(lastLevel, allData.size());
    }

    // TODO: 2/24/2022 Yana hammasiga alohida cachelarda saqlab chiqish kerak

    public ArrayList<TestData3> getAllData() {
        ArrayList<TestData3> data = new ArrayList<>();

        ArrayList<Drawable> images = new ArrayList<>();

        for (int i = 1; i <= 24; i++) {

            for (int j = 1; j <= 2; j++) {
                images.add(getImageFromAssets("image_" + i + "_" + j + ".webp"));
            }
        }
        // TODO: 2/27/2022 Rasm va javoblarni togirlab chiqish kerak 
        TestData3 test1 = new TestData3(
                "ghost", "hghelonsltwe", 0
        );
        test1.addImage(images.get(0));
        test1.addImage(images.get(1));
        data.add(test1);

        TestData3 test2 = new TestData3(
                "blue", "wbaltueterqs", 1
        );
        test2.addImage(images.get(2));
        test2.addImage(images.get(3));
        data.add(test2);

        TestData3 test3 = new TestData3(
                "addres", "addwrdeorlss", 2
        );
        test3.addImage(images.get(4));
        test3.addImage(images.get(5));
        data.add(test3);

        TestData3 test4 = new TestData3(
                "choice", "chaoiycwealk", 3
        );
        test4.addImage(images.get(6));
        test4.addImage(images.get(7));
        data.add(test4);
        TestData3 test5 = new TestData3(
                "cross", "wacrlkosroas", 4
        );
        test5.addImage(images.get(8));
        test5.addImage(images.get(9));
        data.add(test5);
        TestData3 test6 = new TestData3(
                "deep", "brdeeatphoce", 5
        );
        test6.addImage(images.get(10));
        test6.addImage(images.get(11));
        data.add(test6);
        TestData3 test7 = new TestData3(
                "dot", "ndworlodtcom", 6
        );
        test7.addImage(images.get(12));
        test7.addImage(images.get(13));
        data.add(test7);
        TestData3 test8 = new TestData3(
                "draw", "boadolrinawt", 7
        );
        test8.addImage(images.get(14));
        test8.addImage(images.get(15));
        data.add(test8);
        TestData3 test9 = new TestData3(
                "fast", "kftiamsetclo", 8
        );
        test9.addImage(images.get(16));
        test9.addImage(images.get(17));
        data.add(test9);
        TestData3 test10 = new TestData3(
                "float", "dfumaloloaqt", 9
        );
        test10.addImage(images.get(18));
        test10.addImage(images.get(19));
        data.add(test10);
        TestData3 test11 = new TestData3(
                "hint", "wuehginsture", 10
        );
        test11.addImage(images.get(20));
        test11.addImage(images.get(21));
        data.add(test11);
        TestData3 test12 = new TestData3(
                "iron", "diryrntbonrn", 11
        );
        test12.addImage(images.get(22));
        test12.addImage(images.get(23));
        data.add(test12);
        TestData3 test13 = new TestData3(
                "italy", "ercitialbeay", 12
        );
        test13.addImage(images.get(24));
        test13.addImage(images.get(25));
        data.add(test13);
        TestData3 test14 = new TestData3(
                "jump", "jcsumvdspedr", 13
        );
        test14.addImage(images.get(26));
        test14.addImage(images.get(27));
        data.add(test14);
        TestData3 test15 = new TestData3(
                "kick", "welkegicbakt", 14
        );
        test15.addImage(images.get(28));
        test15.addImage(images.get(29));
        data.add(test15);
        TestData3 test16 = new TestData3(
                "narrow", "snairgnrdotw", 15
        );
        test16.addImage(images.get(30));
        test16.addImage(images.get(31));
        data.add(test16);
        TestData3 test17 = new TestData3(
                "park", "plparcarking", 16
        );
        test17.addImage(images.get(32));
        test17.addImage(images.get(33));
        data.add(test17);
        TestData3 test18 = new TestData3(
                "raw", "asmeratoegwg", 17
        );
        test18.addImage(images.get(34));
        test18.addImage(images.get(35));
        data.add(test18);
        TestData3 test19 = new TestData3(
                "shell", "lsohgooelbrl", 18
        );
        test19.addImage(images.get(36));
        test19.addImage(images.get(37));
        data.add(test19);
        TestData3 test20 = new TestData3(
                "slow", "sefltgowealy", 19
        );
        test20.addImage(images.get(38));
        test20.addImage(images.get(39));
        data.add(test20);
        TestData3 test21 = new TestData3(
                "stack", "funstaoinchk", 20
        );
        test21.addImage(images.get(40));
        test21.addImage(images.get(41));
        data.add(test21);
        TestData3 test22 = new TestData3(
                "stick", "stricsrwkbeu", 21
        );
        test22.addImage(images.get(42));
        test22.addImage(images.get(43));
        data.add(test22);
        TestData3 test23 = new TestData3(
                "wreck", "bowraetcunke", 22
        );
        test23.addImage(images.get(44));
        test23.addImage(images.get(45));
        data.add(test23);
        TestData3 test24 = new TestData3(
                "zip", "ezgigdpbfile", 23
        );
        test24.addImage(images.get(46));
        test24.addImage(images.get(47));
        data.add(test24);


        return data;
    }

    public Drawable getImageFromAssets(String fileName) {
        Drawable drawable;
        try {
            // get input stream
            InputStream ims = context.getAssets().open("gameImages3/" + fileName);
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
