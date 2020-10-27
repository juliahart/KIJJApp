package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UpcomingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
    }

    /*
     * Method to go to profile view
     */
    public void goToProfile(View view){
        Intent intent = new Intent( this, ProfileActivity.class );
        // go to home screen
        startActivity( intent );
    }

    /*
     * Method to go back to previous view
     */
    public void goBack(View view){
            finish();
    }
}
