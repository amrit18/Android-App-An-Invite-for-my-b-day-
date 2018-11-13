package com.fin.amrit.amrit_final_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by amrit on 28/03/2018.
 * This is the RsvpScreen class - Has all the methods for the RSVP screen.
 */

public class RsvpScreen extends AppCompatActivity {

    private TextView mTextMessage;
    private EditText mEditTextTo;
    private EditText mEditTextName;
    private EditText mEditTextGuests;
    private EditText mEditTextFood;
    private EditText mEditTextOther;
    private EditText mEditTextMessage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvp_screen);


       //EditText fields for the RSVP screen
        mEditTextTo = findViewById(R.id.yesorno);
        mEditTextName = findViewById(R.id.emailName);
        mEditTextFood = findViewById(R.id.food);
        mEditTextGuests = findViewById(R.id.extraguests);
        mEditTextOther = findViewById(R.id.subject_message);


        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();


            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




    }

    //Method which opens up mail when user clicks send
    private void sendMail() {

        String name = mEditTextName.getText().toString();
        String yesOrNo = mEditTextTo.getText().toString();
        String guestsNumber = mEditTextGuests.getText().toString();
        String food = mEditTextFood.getText().toString();
        String extra = mEditTextOther.getText().toString();



        Intent intent = new Intent(Intent.ACTION_SEND);

        String email[] = { "amritsarai@hotmail.com" };
        String subject = ("R.S.V.P - Amrit's 19th Birthday Party");


        if (yesOrNo.equals("") || name.equals("") || guestsNumber.equals("") || food.equals("") || extra.equals("")){
            Toast.makeText(this, "Please fill in all the text fields before you press send, if the question is not applicable to you just put N/A in the text field.", Toast.LENGTH_LONG).show();
        }


        if (!name.equals("") && !yesOrNo.equals("")  && !guestsNumber.equals("") && !food.equals("") &&  !extra.equals("")  ) {


            String collection = ("What is your name?" + '\n' + name + '\n' + "Can you attend?" + '\n' + yesOrNo
                    + '\n' + "Will you be bringing a plus one?" + '\n' + guestsNumber +
                    '\n' + "Please advise on any dietary requirements:" + '\n' + food + '\n' + "If there are any other " +
                    "other requirements please say below." + '\n' + extra);
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, collection);


            intent.setType("message/rfc822");
            startActivity(intent);

        }


    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent about = new Intent(RsvpScreen.this, AboutScreen.class);
                    startActivity( about );
                    finish();
                    return true;
                case R.id.navigation_dashboard:
                    Intent rsvp = new Intent(RsvpScreen.this, RsvpScreen.class);

                    startActivity(rsvp);
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    Intent map = new Intent(RsvpScreen.this, MapScreen.class);
                    startActivity( map );

                    finish();
                    return true;
            }
            return false;
        }
    };




}


