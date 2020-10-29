package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class NewBookingsActivity extends AppCompatActivity {

    private TextView tv;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbooking);
        seekBar = findViewById(R.id.distance_bar);
        tv = findViewById(R.id.distanceView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText(String.valueOf(seekBar.getProgress()) + " mi");
            }
        });
    }

    /*
     * Method to go to profile view
     */
    public void goToProfile(View view) {
        Intent intent = new Intent(this, LearnMoreActivity.class);
        startActivity(intent);
    }

    /*
     * Method to go to new back to previous view (home)
     */
    public void goBack(View view) {
        finish();
    }

    public void search(View view) {
    }
}

