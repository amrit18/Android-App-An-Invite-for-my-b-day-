package com.fin.amrit.amrit_final_app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

/**
 * Created by amrit on 28/03/2018.
 * This is the AboutScreen class - Has all the methods for the About Screen
 */


public class AboutScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;
    private Button mapButton;
    private Button rsvpButton;
    private GoogleMap mMap;






    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    Intent about = new Intent(AboutScreen.this, AboutScreen.class);

                    startActivity( about );
                    finish();
                    return true;

                case R.id.navigation_dashboard:

                    Intent rsvp = new Intent(AboutScreen.this, RsvpScreen.class);
                    startActivity(rsvp);

                    finish();
                    return true;

                case R.id.navigation_notifications:

                    Intent map = new Intent(AboutScreen.this, MapScreen.class);
                    startActivity( map );

                    finish();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_screen);








        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mapButton = findViewById(R.id.map);
        mapButton.setOnClickListener(this);

        rsvpButton = findViewById(R.id.rsvp);
        rsvpButton.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.map){
            Intent intent = new Intent(AboutScreen.this, MapScreen.class);
            startActivity(intent);
            finish();
        }

        else if (view.getId() == R.id.rsvp){
            Intent intent2 = new Intent(AboutScreen.this, RsvpScreen.class);
            startActivity(intent2);
            finish();
        }

        else{
            //Do nothing
        }

    }










}


