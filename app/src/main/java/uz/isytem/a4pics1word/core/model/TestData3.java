package uz.isytem.a4pics1word.core.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class TestData3 {
    private int index;
    private String answer;
    private String variant;
    private ArrayList<Drawable> images;


    public TestData3(String answer, String variant, ArrayList<Drawable> images) {
        this.answer = answer;
        this.variant = variant;
        this.images = images;
    }

    public TestData3(String answer, String variant, int index) {
        this.answer = answer;
        this.variant = variant;
        this.index = index;
        this.images = new ArrayList<>();
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public ArrayList<Drawable> getImages() {
        return images;
    }

    public void addImage(Drawable image) {
        images.add(image);
    }

    @Override
    public String toString() {
        return "TestData3{" +
                "answer='" + answer + '\'' +
                ", variant='" + variant + '\'' +
                ", images=" + images +
                '}';
    }
}
