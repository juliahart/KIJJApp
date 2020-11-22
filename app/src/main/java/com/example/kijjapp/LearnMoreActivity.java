package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LearnMoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    /**
     * method to go back to previous view (new booking view)
     */
    public void goBack(View view) {
        finish();
    }

    /**
     * TO DO!!!!
     */
    public void apply(View view)
    {
    }
}
