package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ercpng.redbirdhacks2016.R;

public class TestOneInstruction extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_one);
    }

    public void goToColor(View v) {
        startActivity(new Intent(getApplicationContext(), ExamActivityOne.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
