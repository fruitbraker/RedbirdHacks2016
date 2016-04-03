package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ercpng.redbirdhacks2016.R;


public class TransitionToNBack extends AppCompatActivity {

    private TextView tvCorrect, tvIncorrect, tvAvg, tvAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_n);

        tvCorrect = (TextView) findViewById(R.id.tvCorrect);
        tvCorrect.setText("Number of correct: " + MyApplication.getInstance().getCorrect());

        tvIncorrect = (TextView) findViewById(R.id.tvIncorrect);
        tvIncorrect.setText("Number of incorrect: " + MyApplication.getInstance().getIncorrect());


        tvAvg = (TextView) findViewById(R.id.tvAverageTime);

        tvAvg.setText("Average time (ms): " + (MyApplication.getInstance().getTime()/(MyApplication.getInstance().getCorrect()
                + MyApplication.getInstance().getIncorrect())));

        tvAll = (TextView) findViewById(R.id.tvAllTime);
        tvAll.setText(MyApplication.getInstance().getAllTime());

    }

    public void nextGame(View v) {
        MyApplication.getInstance().reset();
        startActivity(new Intent(getApplicationContext(), ExamActivityTwo.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
