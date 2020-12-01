package com.example.kijjapp;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PointsActivity extends AppCompatActivity {
    //public static final String PointsURL = "http://klmatrangola.cs.loyola.edu/kijjTesting/sitterPoints.php";
    public static final String PointsURL = "http://kijj.cs.loyola.edu/model/sitterPoints.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        updatePointsView();
    }

    public void updatePointsView(){
        Log.w("MA", "points = "+ MainActivity.sitter.getPoints());
        TextView pointsTV = (TextView) findViewById( R.id.yourPoints );
        pointsTV.setText( "You have: "+ String.valueOf(MainActivity.sitter.getPoints())  + " points" );
        String left = String.valueOf( 25 - MainActivity.sitter.getPoints());
        TextView leftTV = (TextView) findViewById( R.id.pointsToGet );
        leftTV.setText(left + " more points until you can redeem");

    }

    /**
     * Method to go to back to previous view (home)
     */
    public void goBack(View view) {
        finish();
    }



    /**
     * I think that this is working
     */
    public void redeemPoints(View v)
    {
        int points;
        points = MainActivity.sitter.getPoints();
        if(points < 25) {
            showAlertDialogNoPoints();
            updatePointsView();
        }
        else
        {
            showAlertHasPoints();
        }

    }

    /**
     * method to show alert if the user has enough points for a gift card
     */
    public void showAlertHasPoints() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Gift Card!");
        builder.setMessage("You get a $25 Amazon Gift Card");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * Method to show alert if user doesn't have enough points for a gift card
     */
    public void showAlertDialogNoPoints() {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sorry!");
        builder.setMessage("You don't have enough points to redeem a gift card.");
        // add a button
        builder.setPositiveButton("OK", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
