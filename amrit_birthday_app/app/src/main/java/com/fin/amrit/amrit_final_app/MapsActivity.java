package com.fin.amrit.amrit_final_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

/**
 * Created by amrit on 28/03/2018.
 * This is the MapsActivity class - Has all the methods for the MapsActivity screen using Google API
 */


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent about = new Intent(MapsActivity.this, AboutScreen.class);
                    startActivity(about);
                    finish();
                    return true;

                case R.id.navigation_dashboard:
                    Intent rsvp = new Intent(MapsActivity.this, RsvpScreen.class);
                    startActivity(rsvp);
                    finish();
                    return true;

                case R.id.navigation_notifications:
                    Intent map = new Intent(MapsActivity.this, MapScreen.class);
                    startActivity(map);
                    finish();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng birthday = new LatLng(52.491536, -1.967974 );
        mMap.addMarker(new MarkerOptions().position(birthday).title("Party is here"));
        mMap.moveCamera( CameraUpdateFactory.zoomTo( 16.5f ));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(birthday));
    }
}
