package com.fin.amrit.amrit_final_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by amrit on 28/03/2018.
 * This is the MapScreen class - Has all the methods for the Map screen
 */

public class MapScreen extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextMessage;
    private Button search;
    private Button marker;
    private GoogleMap mMap;
    public final static String DEBUG = "DEBUG";
    public final static String SPACE = " ";
    public final static String PLUS = "+";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent about = new Intent(MapScreen.this, AboutScreen.class);
                    startActivity(about);
                    finish();
                    return true;

                case R.id.navigation_dashboard:
                    Intent rsvp = new Intent(MapScreen.this, RsvpScreen.class);
                    startActivity(rsvp);
                    finish();
                    return true;

                case R.id.navigation_notifications:
                    Intent map = new Intent(MapScreen.this, MapScreen.class);
                    startActivity(map);
                    finish();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);



        Button currentLocation = (Button) findViewById(R.id.goButton);
        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText location = (EditText) findViewById(R.id.TFlocation);
                location.setText("");
                Intent newScreen = new Intent(MapScreen.this, MapsActivity.class);
                startActivity(newScreen);
                finish();
            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    public void onClick(View view){
        EditText location = (EditText) findViewById(R.id.TFlocation);
        String address = location.getText().toString();
        if (!address.equals("")) {
            address = address.replace(SPACE, PLUS);
            Log.d(DEBUG, "Locations is: " + address);
            Uri geo = Uri.parse(address);
            location.setText("");



            try {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + geo + "&daddr=" + 52.491536 + "," + -1.967974));


                startActivity(intent);


            } catch (Exception e) {
                String error = e.getMessage();
                Log.d(DEBUG, error);
            }
        }


        if (address.equals("")) {
            Toast.makeText(this, "You need to enter a place", Toast.LENGTH_LONG).show();
        } else {

            Log.d(DEBUG, "Whoops, not the Go button");
        }
    }



    }
