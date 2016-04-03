package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ercpng.redbirdhacks2016.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MyApplication.getInstance();
    }


    public void goToColor(View view) {
        startActivity(new Intent(getApplicationContext(), TestOneInstruction.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
