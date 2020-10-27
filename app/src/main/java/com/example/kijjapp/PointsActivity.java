package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PointsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
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
