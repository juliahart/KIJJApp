package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /*
    * Method to go to the upcoming booking view
     */
    public void goToUpcomingBooking(View view){

        Intent intent = new Intent( this, UpcomingActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go to new booking view
     */
    public void goToNewBooking(View view){

        Intent intent = new Intent( this, NewBookingsActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go to profile view
     */
    public void goToProfile(View view){

        Intent intent = new Intent( this, ProfileActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go to points view
     */
    public void goToPoints(View view){

        Intent intent = new Intent( this, PointsActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go to back to previous view (login page/signup page)
     */
    public void goBack(View view) {
        finish();
    }

}
