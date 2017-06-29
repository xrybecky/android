package com.bicyclebell.viko.bicyclebell;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Context context;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        // Activate FontAwesome
        setAwesomeTypeFace();

        // Button
        Button button = (Button) findViewById(R.id.main_ring_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Threading
                new Thread(new Runnable() {
                    public void run() {

                        // Media player
                        if(mediaPlayer != null){
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }

                        mediaPlayer = MediaPlayer.create(context, R.raw.bicycle_bell_07);
                        mediaPlayer.start();
                    }
                }).start();

            }
        });

        // Set Button animation
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                R.animator.button_pulse);
        set.setTarget(button);
        set.start();

    }

    private void setAwesomeTypeFace() {
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        // Main Ring Button
        Button button = (Button) findViewById(R.id.main_ring_button);
        button.setTypeface(fontAwesome);

        // Next Component
    }
}
