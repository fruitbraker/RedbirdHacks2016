package com.ercpng.redbirdhacks2016.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ercpng.redbirdhacks2016.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


public class TransitionToNBack extends AppCompatActivity {

    private static String auth_key = "ZDcxN2JmYTktNTE0Mi00MmRhLWJmNTYtN2Y5N2Q2NmYwNzliYTgzMDdlOWUtZTM3";

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
        tvAll.setText("Correct:    " + MyApplication.getInstance().getAllTimeCorrect() + "Incorrect:   "
            + MyApplication.getInstance().getAllTimeIncorrect());

        new DoSpark().execute("https://api.ciscospark.com/v1/messages", "POST",
                "Color Exam:        Correct:    " + MyApplication.getInstance().getAllTimeCorrect() + "Incorrect:   "
                        + MyApplication.getInstance().getAllTimeIncorrect());

    }

    public void nextGame(View v) {
        MyApplication.getInstance().reset();
        startActivity(new Intent(getApplicationContext(), TestTwoInstruction.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    class DoSpark extends AsyncTask<String, Void, Void> {

        public DoSpark() {

        }

        @Override
        protected Void doInBackground(String... params) {

            URL url;
            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
                return null;
            }
            HttpURLConnection con;
            try {
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod(params[1]);
                con.setInstanceFollowRedirects(true);
                con.setRequestProperty("Content-type", "application/json");
                con.setRequestProperty ("Authorization", "Bearer " + auth_key);
                con.setReadTimeout(10000);
                con.setConnectTimeout(15000);
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);

                List<AbstractMap.SimpleEntry<String, String>> paramsList =
                        new ArrayList<AbstractMap.SimpleEntry<String, String>>();
                paramsList.add(new AbstractMap.SimpleEntry<String, String>("toPersonId", "722bb271-d7ca-4bce-a9e3-471e4412fa77"));
                paramsList.add(new AbstractMap.SimpleEntry<String, String>("text", "Hell hath no fury like a Java scorned"));
                String post_data = "{\"toPersonId\": \"722bb271-d7ca-4bce-a9e3-471e4412fa77\", \"text\": \"" + params[2] + "\"}";
                OutputStream os = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(post_data);
                writer.flush();
                writer.close();
                os.close();

                con.connect();
                Log.d("SPARKY SPARKY BOOM MAN", "" + con.getResponseCode());
                System.out.println(con.getErrorStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
