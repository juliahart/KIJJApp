package com.example.kijjapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PointsActivity extends AppCompatActivity {
    public static final String PointsURL = "http://klmatrangola.cs.loyola.edu/kijjTesting/sitterPoints.php";
    //public static final String PointsURL = "http://kijj.cs.loyola.edu/model/sitterPoints.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        updatePointsView();
    }

    public void updatePointsView(){
        Log.w("MA", "points = "+MainActivity.sitter.getPoints());
        TextView pointsTV = (TextView) findViewById( R.id.yourPoints );
        pointsTV.setText( "You have: "+ String.valueOf(MainActivity.sitter.getPoints())  + " points" );
        String left = String.valueOf( 25 - MainActivity.sitter.getPoints());
        TextView leftTV = (TextView) findViewById( R.id.pointsToGet );
        leftTV.setText(left + " more points until you can redeem");

    }

    /*
     * Method to go to back to previous view (home)
     */
    public void goBack(View view) {
        finish();
    }

    /*
     * TO DO!!
     */
    public void redeemPoints(View v)
    {
    }
}
