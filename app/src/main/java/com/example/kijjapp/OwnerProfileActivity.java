package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
/**
 * This is the OwnerProfileActivity Class
 * @authors: Team KIJJ
 */

public class OwnerProfileActivity extends AppCompatActivity {

    UpcomingActivity activity;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerprofile);
        showProfile();
    }

    /**
     * Method to show the owner's profile
     */
    public void showProfile(){
        String my_string = getIntent().getStringExtra("key");
        TextView nameTV = (TextView) findViewById(R.id.name);
        String name = "Name: " + my_string;
        nameTV.setText(name);

        String my_string2 = getIntent().getStringExtra("key2");
        TextView addyTV = (TextView) findViewById(R.id.address);
        String addy = "Address: "  + my_string2;
        addyTV.setText(addy);

        String my_string3 = getIntent().getStringExtra("key3");
        TextView cityStateZipTV = (TextView) findViewById(R.id.cityStateZip);
        String cityStateZip =  my_string3;
        cityStateZipTV.setText(cityStateZip);
    }


    /**
     * method to go back to previous view
     */
    public void goBack(View view)
    {
        finish();
    }
}
