package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NewBookingsActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_newbooking);
        }

    /*
     * Method to go to profile view
     */
        public void goToProfile(View view)
        {
            Intent intent = new Intent(this, LearnMoreActivity.class);
            startActivity(intent);
        }

    /*
     * Method to go to new back to previous view (home)
     */
        public void goBack(View view) {
            finish();
        }

    public void search(View view)
    {
    }
}

