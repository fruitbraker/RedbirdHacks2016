package com.ercpng.redbirdhacks2016.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ercpng.redbirdhacks2016.R;


public class InfoActivity extends AppCompatActivity {

    private TextView tvCorrect, tvIncorrect, tvAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvCorrect = (TextView) findViewById(R.id.tvCorrect);
        tvCorrect.setText("Number of correct: " + MyApplication.getCorrect());

        tvIncorrect = (TextView) findViewById(R.id.tvIncorrect);
        tvIncorrect.setText("Number of incorrect: " + MyApplication.getIncorrect());


        tvAvg = (TextView) findViewById(R.id.tvAverageTime);
        tvAvg.setText("Average time (ms): " + (MyApplication.getTime()/(MyApplication.getCorrect() + MyApplication.getIncorrect())));


    }
}
