package com.fin.amrit.amrit_final_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by amrit on 28/03/2018.
 * This is the SplashScreen class - Has all the methods for the Splash ScreenI
 */

public class SplashScreen extends AppCompatActivity implements Runnable {
    private TextView spalsh;
    private ImageView party;
    Animation fromButtom;
    Animation fromTop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler splashHandler = new Handler();
        splashHandler.postDelayed(this, 5000);

        //Adding animation method
        spalsh = findViewById(R.id.splash_text);
        fromButtom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        spalsh.setAnimation(fromButtom);

        party = findViewById(R.id.splash);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        party.setAnimation(fromTop);



        MediaPlayer sound = MediaPlayer.create(SplashScreen.this, R.raw.party_horn);
        sound.start();





    }

    @Override
    public void run(){
        Intent intent = new Intent ( SplashScreen.this, AboutScreen.class );
        SplashScreen.this.startActivity( intent );

        finish();

        //Adding background music to the app after the splash screen ends
        MediaPlayer sound = MediaPlayer.create(SplashScreen.this, R.raw.birthday_song);
        sound.start();
        sound.setLooping(true);




    }
}
