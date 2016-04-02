package com.ercpng.redbirdhacks2016.activities;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication instance;

    private int correct = 0, incorrect = 0;
    private long addedTime = 0;
    private String allTime = "";


    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void correct() {
        correct++;
    }

    public void incorrect() {
        incorrect++;
    }

    public int getCorrect() {
        return correct;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void addTime(long time) {
        addedTime += time;
        allTime += time + "  ";
    }

    public String getAllTime() {
        return allTime;
    }

    public long getTime() {
        return addedTime;
    }

    public void reset() {
        correct = incorrect = 0;
        addedTime = 0;
    }

    public static MyApplication getInstance() {
        if(instance == null){
            instance = new MyApplication();
        }
        return instance;
    }

}
