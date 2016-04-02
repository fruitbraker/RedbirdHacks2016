package com.ercpng.redbirdhacks2016.activities;

import android.app.Application;

public class MyApplication extends Application{

    private static int correct = 0, incorrect = 0;
    private static long allTime = 0;


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static void correct() {
        correct++;
    }

    public static void incorrect() {
        incorrect++;
    }

    public static int getCorrect() {
        return correct;
    }

    public static int getIncorrect() {
        return incorrect;
    }

    public static void addTime(long time) {
        allTime += time;
    }

    public static long getTime() {
        return allTime;
    }
}
