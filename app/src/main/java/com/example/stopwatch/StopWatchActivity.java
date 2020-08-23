package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        icanchor = findViewById(R.id.icanchor);
        btnstop = findViewById(R.id.btnstop);
        timer = findViewById(R.id.timer);

        //create optional animation
        btnstop.setAlpha(0);

        //load animations
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        //import fonts
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");

        //customize fonts
        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.animate().alpha(0).setDuration(300).start();
                timer.stop();
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                // start time on timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
    }

}