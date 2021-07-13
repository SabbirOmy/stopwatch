package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button butt;
    ImageView ima;
    Animation atg,btgone,btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = findViewById(R.id.btn);
        ima = findViewById(R.id.imv1);

        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1 = new Intent(MainActivity.this, watch.class);
                int1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(int1);
            }
        });

        atg  = AnimationUtils.loadAnimation(this,R.anim.atg);
        btgone  = AnimationUtils.loadAnimation(this,R.anim.btg1);
        btgtwo  = AnimationUtils.loadAnimation(this,R.anim.btg2);

        ima.startAnimation(atg);
        butt.startAnimation(btgtwo);
    }
}
