package com.ercpng.redbirdhacks2016.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ercpng.redbirdhacks2016.R;

public class SplashActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.textView);
    }


    public void makeToast(View view) {
        Toast.makeText(getApplicationContext(), "Going to test", Toast.LENGTH_LONG).show();
        tv.setText("Changed text");
    }
}
