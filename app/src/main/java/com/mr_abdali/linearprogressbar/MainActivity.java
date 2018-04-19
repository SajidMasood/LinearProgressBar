package com.mr_abdali.linearprogressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // progress bar reference
        progressBar = (ProgressBar) findViewById(R.id.linearProgressBar_id);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(20);  // initial value
        progressBar.setSecondaryProgress(0);
        progressBar.setMax(100); // max value

        // Handler
        handler = new Handler();

        // Runnable
        runnable = new Runnable() {
            @Override
            public void run() {
                // <code></code>
                if (++i <= 100){
                    //
                    progressBar.setProgress(i);
                    progressBar.setSecondaryProgress(i+10);
                }else {
                    // <code></code>
                    //progressBar.setVisibility(View.GONE);
                    timer.cancel();
                }
            }
        };

        // timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },8000,300);
    }
}
