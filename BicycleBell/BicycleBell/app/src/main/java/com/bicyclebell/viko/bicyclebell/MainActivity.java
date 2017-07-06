package com.bicyclebell.viko.bicyclebell;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bicyclebell.viko.bicyclebell.fragments.AuthenticationFragment;
import com.bicyclebell.viko.bicyclebell.fragments.SimpleLocationFragment;

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
                        if (mediaPlayer != null) {
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


        // More features button
        Button buttonMoreFeatures = (Button) findViewById(R.id.more_features_button);
        buttonMoreFeatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: check for internet connection

                // TODO: float out animation
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(context,
                        R.animator.flight_up);
                set.setTarget(view);

                set.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        // find parent layout
                        LinearLayout ll = (LinearLayout) findViewById(R.id.viewA);
                        ll.removeAllViews();

                        // replace content with fragment
                        FragmentManager fragMan = getFragmentManager();
                        FragmentTransaction fragTransaction = fragMan.beginTransaction();

                        SimpleLocationFragment fragmentSimpleLocation = new SimpleLocationFragment();
                        fragTransaction.add(ll.getId(), fragmentSimpleLocation , "fragmentSimpleLocation");
                        fragTransaction.commit();

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                set.start();
            }

        });

    }

    private void setAwesomeTypeFace() {
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        // Main Ring Button
        Button button = (Button) findViewById(R.id.main_ring_button);
        button.setTypeface(fontAwesome);

        // Next Component
    }
}
