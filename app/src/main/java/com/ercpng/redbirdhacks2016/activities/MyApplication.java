package com.ercpng.redbirdhacks2016.activities;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication instance;

    private int correct = 0, incorrect = 0;
    private long addedTime = 0;
    private String allTimeCorrect = "", allTimeIncorrect = "";


    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void correct(long time) {
        correct++;
        addedTime += time;
        allTimeCorrect += time + "  ";
    }

    public void incorrect(long time) {
        incorrect++;
        addedTime += time;
        allTimeIncorrect += time + "  ";
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public String getAllTimeCorrect() {
        return allTimeCorrect;
    }

    public String getAllTimeIncorrect() {
        return allTimeIncorrect;
    }

    public long getTime() {
        return addedTime;
    }

    public long getAddedTime() {
        return addedTime;
    }

    public void reset() {
        correct = incorrect = 0;
        addedTime = 0;
        allTimeCorrect = allTimeIncorrect = "";
    }

    public static MyApplication getInstance() {
        if(instance == null){
            instance = new MyApplication();
        }
        return instance;
    }

}
