package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ercpng.redbirdhacks2016.R;


public class InfoActivity extends AppCompatActivity {

    private TextView tvCorrect, tvIncorrect, tvAvg, tvAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tvCorrect = (TextView) findViewById(R.id.tvCorrectN);
        tvCorrect.setText("Number of correct: " + MyApplication.getInstance().getCorrect());

        tvIncorrect = (TextView) findViewById(R.id.tvIncorrectN);
        tvIncorrect.setText("Number of incorrect: " + MyApplication.getInstance().getIncorrect());


        tvAvg = (TextView) findViewById(R.id.tvAverageTimeN);

        tvAvg.setText("Average time (ms): " + (MyApplication.getInstance().getTime()/(MyApplication.getInstance().getCorrect()
                + MyApplication.getInstance().getIncorrect())));

        tvAll = (TextView) findViewById(R.id.tvAllTimeN);
        tvAll.setText(MyApplication.getInstance().getAllTime());

    }

    public void nextGame(View v) {
        MyApplication.getInstance().reset();
        startActivity(new Intent(getApplicationContext(), SplashActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
