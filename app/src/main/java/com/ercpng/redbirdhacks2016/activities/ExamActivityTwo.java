package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ercpng.redbirdhacks2016.R;

import java.util.Random;

public class ExamActivityTwo extends AppCompatActivity implements View.OnClickListener {

    private static final long EFFECTIVE_TIMER = 10000;

    private LinearLayout zero, two, three;
    private RelativeLayout one;
    private Button same, different;

    private TextView timer;

    private Random random;

    private int previousState, lastTwoState, currentPos, counter;

    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_two);
        init();
    }

    private void init() {
        zero = (LinearLayout) findViewById(R.id.zero);
        one = (RelativeLayout) findViewById(R.id.one);
        two = (LinearLayout) findViewById(R.id.two);
        three = (LinearLayout) findViewById(R.id.three);

        same = (Button) findViewById(R.id.twoSame);
        different = (Button) findViewById(R.id.twoDifferent);

        timer = (TextView) findViewById(R.id.tvTimerN);

        same.setOnClickListener(this);
        different.setOnClickListener(this);

        random = new Random();

        previousState = 0;
        lastTwoState = 0;

        Timer time = new Timer(timer);
        time.run();

        Handler generateFirstTwo = new Handler();
        generateFirstTwo.postDelayed(new Runnable() {

            @Override
            public void run() {
                generateFirstTwo();
            }
        }, 2000);

    }

    private void generateFirstTwo() {
        currentPos = random.nextInt((3-0) + 1) + 0;
        if(counter == 0)
            lastTwoState = currentPos;
        else if(counter == 1)
            previousState = currentPos;
        Toast.makeText(getApplicationContext(), "" + currentPos, Toast.LENGTH_SHORT).show();
        switch(currentPos) {
            case 0:
                zero.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 1:
                one.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 2:
                two.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 3:
                three.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            default:
                Toast.makeText(getApplicationContext(), "BUGSADFASDJFAWESf", Toast.LENGTH_LONG).show();
        }
        Handler sleep = new Handler();
        sleep.postDelayed(new Runnable() {

            @Override
            public void run() {
                resetColor(currentPos);
                if(counter < 1) {
                    counter ++;
                    generateFirstTwo();
                } else {
                    generateNext();
                }

            }
        }, 1000);


    }

    private void resetColor(int pos) {
        switch(pos) {
            case 0:
                zero.setBackgroundColor(Color.rgb(255, 64, 129));
                break;
            case 1:
                one.setBackgroundColor(Color.rgb(255, 64, 129));
                break;
            case 2:
                two.setBackgroundColor(Color.rgb(255, 64, 129));
                break;
            case 3:
                three.setBackgroundColor(Color.rgb(255, 64, 129));
                break;
            default:
                Toast.makeText(getApplicationContext(), "BUGSADFASDJFAWESf", Toast.LENGTH_LONG).show();
        }
    }

    private void generateNext() {
        resetColor(currentPos);
        currentPos = random.nextInt((3-0) + 1) + 0;
        Log.d("POSITIONG", "Last 2:  " + lastTwoState + "        Previous:    " + previousState);
        startTime = SystemClock.elapsedRealtimeNanos();
        switch(currentPos) {
            case 0:
                zero.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 1:
                one.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 2:
                two.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            case 3:
                three.setBackgroundColor(Color.rgb(63, 81, 181));
                break;
            default:
                Toast.makeText(getApplicationContext(), "BUGSADFASDJFAWESf", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View v) {
        if(counter == 1) {
            switch (v.getId()) {
                case R.id.twoSame:
                    checkCorrect(true);
                    break;
                case R.id.twoDifferent:
                    checkCorrect(false);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "LOL BUGHGUGJ", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkCorrect(boolean i) {
        long elapsedTime = (SystemClock.elapsedRealtimeNanos() - startTime) / 1000000;

        if(i) {
            if(currentPos == lastTwoState) {
                MyApplication.getInstance().correct(elapsedTime);
                Toast.makeText(ExamActivityTwo.this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                MyApplication.getInstance().incorrect(elapsedTime);
                Toast.makeText(ExamActivityTwo.this, "Incorrect", Toast.LENGTH_SHORT).show();
            }
        } else {
            if(currentPos == lastTwoState) {
                MyApplication.getInstance().incorrect(elapsedTime);
                Toast.makeText(ExamActivityTwo.this, "Incorrect", Toast.LENGTH_SHORT).show();
            } else {
                MyApplication.getInstance().correct(elapsedTime);
                Toast.makeText(ExamActivityTwo.this, "Correct", Toast.LENGTH_SHORT).show();
            }
        }
        lastTwoState = previousState;
        previousState = currentPos;
        generateNext();
    }

    class Timer implements Runnable {

        TextView tvTimer;

        Timer(TextView tv) {
            tvTimer = tv;

            new CountDownTimer(EFFECTIVE_TIMER, 1000) {

                public void onTick(long millisUntilFinished) {
                    int seconds = (int) millisUntilFinished / 1000;
                    if(seconds >= 10) {
                        tvTimer.setText("0:" + seconds);
                    } else {
                        tvTimer.setText("0:0" + seconds);
                    }

                }

                public void onFinish() {
                    startActivity(new Intent(getApplicationContext(), InfoActivityFinal.class));
                }
            }.start();

        }

        @Override
        public void run() {

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
