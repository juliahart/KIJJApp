package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    /*
    * method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }


    /*
     * TO DO!!
     */
    public void editProfile(View view)
    {
    }
}
