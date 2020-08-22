package com.varsitycollege.ctill.birdgame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;

    // Manage data between UI thread and program
    private Handler handler = new Handler();

    // Setting game timer
    private final static long TIMER_INTERVAL = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gameView = new GameView(this);
        super.onCreate(savedInstanceState);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        }, 0, TIMER_INTERVAL);
    }
}
