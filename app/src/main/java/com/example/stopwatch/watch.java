package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class watch extends AppCompatActivity {

    Button bstart,bstop;
    ImageView ktc;
    Animation round;
    Chronometer here;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        bstart = findViewById(R.id.bt1);
        bstop = findViewById(R.id.bt2);
        ktc = findViewById(R.id.kata);
        here = findViewById(R.id.mtr);

        bstop.setAlpha(0);
        round = AnimationUtils.loadAnimation(this, R.anim.rounding);

        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ktc.startAnimation(round);
                bstart.animate().alpha(0).setDuration(300).start();
                bstop.animate().alpha(1).translationY(-80).setDuration(300).start();

                here.setBase(SystemClock.elapsedRealtime());
                here.start();
            }
        });

        bstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ktc.clearAnimation();
                bstart.animate().alpha(1).translationY(-80).setDuration(300).start();
                bstop.animate().alpha(0).setDuration(300).start();
                here.stop();
            }
        });

    }
}
