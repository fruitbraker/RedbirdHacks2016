package com.ercpng.redbirdhacks2016.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ercpng.redbirdhacks2016.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bWhite, bGreen, bYellow, bBlue, bBlack, bBrown;
    private TextView tv;
    private Toast toast;

    private Random random;

    private String[] color = new String[6];
    private int textColor, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bWhite = (Button) findViewById(R.id.bWhite);
        bGreen = (Button) findViewById(R.id.bGreen);
        bYellow = (Button) findViewById(R.id.bYellow);
        bBlue = (Button) findViewById(R.id.bBlue);
        bBlack = (Button) findViewById(R.id.bBlack);
        bBrown = (Button) findViewById(R.id.bBrown);

        bWhite.setOnClickListener(this);
        bGreen.setOnClickListener(this);
        bYellow.setOnClickListener(this);
        bBlue.setOnClickListener(this);
        bBlack.setOnClickListener(this);
        bBrown.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.tvColor);

        color[0] = "White";
        color[1] = "Green";
        color[2] = "Yellow";
        color[3] = "Blue";
        color[4] = "Black";
        color[5] = "Brown";

        random = new Random();
        toast = new Toast(getApplicationContext());

        generateNext();
    }

    private void generateNext() {
        textColor = random.nextInt((5-0) + 1) + 0;
        text = random.nextInt((5-0) + 1) + 0;

        tv.setText(color[text]);

        switch(textColor) {
            case 0:
                //white
                tv.setTextColor(Color.rgb(255, 225, 255));
                break;
            case 1:
                //green
                tv.setTextColor(Color.rgb(37, 90, 0));
                break;
            case 2:
                //yellow
                tv.setTextColor(Color.rgb(255, 255, 0));
                break;
            case 3:
                //blue
                tv.setTextColor(Color.rgb(63, 81, 181));
                break;
            case 4:
                //black
                tv.setTextColor(Color.rgb(0, 0, 0));
                break;
            case 5:
                //brown
                tv.setTextColor(Color.rgb(124, 62, 0));
                break;
            default:
                Toast.makeText(getApplicationContext(), "BUG BUG", Toast.LENGTH_LONG).show();
        }
    }

    private void checkAnswer(int input) {
        if(input == textColor) {
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.makeText(getApplicationContext(), "Whoops!", Toast.LENGTH_SHORT).show();
        }
        generateNext();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bWhite:
                checkAnswer(0);
                break;
            case R.id.bGreen:
                checkAnswer(1);
                break;
            case R.id.bYellow:
                checkAnswer(2);
                break;
            case R.id.bBlue:
                checkAnswer(3);
                break;
            case R.id.bBlack:
                checkAnswer(4);
                break;
            case R.id.bBrown:
                checkAnswer(5);
                break;
            default:
                Toast.makeText(MainActivity.this, "Uhoh, BUG BUG BUG BUG BUG. SQUASH IT MUAHAHAHA", Toast.LENGTH_SHORT).show();
        }

    }
}
