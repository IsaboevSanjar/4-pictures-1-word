package uz.isytem.a4pics1word.core.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import uz.isytem.a4pics1word.core.caches.LevelCache4;
import uz.isytem.a4pics1word.core.caches.MaxScoreCache;
import uz.isytem.a4pics1word.core.caches.ScoreCache4;
import uz.isytem.a4pics1word.core.model.TestData4;

public class DataLoader4 {
    private final Context context;
    private int lastLevel;
    private int lastScore;

    public DataLoader4(Context context) {
        this.context = context;
        LevelCache4.init4(context);
        ScoreCache4.initScore4(context);
        MaxScoreCache.initMaxScore(context);
        lastLevel = LevelCache4.getLevelCache().getLastLevel();
    }

    public List<TestData4> getRestData() {
        ArrayList<TestData4> allData = getAllData();
        return allData.subList(lastLevel, allData.size());
    }

    // TODO: 2/24/2022 Yana hammasiga alohida cachelarda saqlab chiqish kerak

    public ArrayList<TestData4> getAllData() {
        ArrayList<TestData4> data = new ArrayList<>();

        ArrayList<Drawable> images = new ArrayList<>();
        for (int i = 1; i <= 22; i++) {
            images.add(getImageFromAssets("image_" + i + ".webp"));
        }
        // TODO: 2/27/2022 Rasm va javoblarni togirlab chiqish kerak


        // TODO: 2/27/2022 Ramni korsatmiyapti Manimcha arrraylistga solgan uchun bolse kerak
        TestData4 test1 = new TestData4(
                "long", "taldrowonggy", 0
        );
        test1.addImage(images.get(0));
        data.add(test1);

        TestData4 test2 = new TestData4(
                "snore", "yslsneorperx", 1
        );
        test2.addImage(images.get(1));
        data.add(test2);

        TestData4 test3 = new TestData4(
                "sword", "bstwoolrygdw", 2
        );
        test3.addImage(images.get(2));
        data.add(test3);

        TestData4 test4 = new TestData4(
                "party", "pdairctosyyt", 3
        );
        test4.addImage(images.get(3));
        data.add(test4);

        TestData4 test5 = new TestData4(
                "yucky", "weyuscfkfyeq", 4
        );
        test5.addImage(images.get(4));
        data.add(test5);
        TestData4 test6 = new TestData4(
                "avoid", "elatveogried", 5
        );
        test6.addImage(images.get(5));
        data.add(test6);
        TestData4 test7 = new TestData4(
                "awake", "awakwaupkmoe", 6
        );
        test7.addImage(images.get(6));
        data.add(test7);
        TestData4 test8 = new TestData4(
                "case", "icphoasneewr", 7
        );
        test8.addImage(images.get(7));
        data.add(test8);

        TestData4 test9 = new TestData4(
                "dental", "wtideenhtapl", 8
        );
        test9.addImage(images.get(8));
        data.add(test9);
        TestData4 test10 = new TestData4(
                "dove", "ybidordvflye", 9
        );
        test10.addImage(images.get(9));
        data.add(test10);
        TestData4 test11 = new TestData4(
                "early", "meoranirnlgy", 10
        );
        test11.addImage(images.get(10));
        data.add(test11);
        TestData4 test12 = new TestData4(
                "guffaw", "guloffghtaow", 11
        );
        test12.addImage(images.get(11));
        data.add(test12);
        TestData4 test13 = new TestData4(
                "iris", "ieyerihertys", 12
        );
        test13.addImage(images.get(12));
        data.add(test13);
        TestData4 test14 = new TestData4(
                "joker", "ejaoctorkefr", 13
        );
        test14.addImage(images.get(13));
        data.add(test14);
        TestData4 test15 = new TestData4(
                "kind", "ehkelpintodo", 14
        );
        test15.addImage(images.get(14));
        data.add(test15);
        TestData4 test16 = new TestData4(
                "mince", "ometineatcem", 15
        );
        test16.addImage(images.get(15));
        data.add(test16);
        TestData4 test17 = new TestData4(
                "pulse", "epurtlshaned", 16
        );
        test17.addImage(images.get(16));
        data.add(test17);

        TestData4 test18 = new TestData4(
                "soil", "wshanoidlbro", 17
        );
        test18.addImage(images.get(17));
        data.add(test18);

        TestData4 test19 = new TestData4(
                "satin", "qihetsaxbtin", 18
        );
        test19.addImage(images.get(18));
        data.add(test19);

        TestData4 test20 = new TestData4(
                "shears", "shewearfsqoi", 19
        );
        test20.addImage(images.get(19));
        data.add(test20);

        TestData4 test21 = new TestData4(
                "shiver", "dshcivsnower", 20
        );
        test21.addImage(images.get(20));
        data.add(test21);

        TestData4 test22 = new TestData4(
                "you", "oaeyvtbofesu", 21
        );
        test22.addImage(images.get(21));
        data.add(test22);


        return data;
    }

    public Drawable getImageFromAssets(String fileName) {
        Drawable drawable;
        try {
            // get input stream
            InputStream ims = context.getAssets().open("gameImages4/" + fileName);
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
