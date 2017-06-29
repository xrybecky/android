package com.bicyclebell.viko.bicyclebell;

import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        // Activate FontAwesome
        setAwesomeTypeFace();

        // Media player
        final MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.bicycle_bell_12);

        Button button = (Button) findViewById(R.id.main_ring_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

    }

    private void setAwesomeTypeFace(){
        Typeface fontAwesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        // Main Ring Button
        Button button = (Button) findViewById(R.id.main_ring_button);
        button.setTypeface(fontAwesome);

        // Next Component
    }
}
