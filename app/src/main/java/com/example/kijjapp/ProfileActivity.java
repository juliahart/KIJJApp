package com.example.kijjapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        showProfile();

    }

    public void showProfile(){
        TextView nameTV = (TextView) findViewById(R.id.name);
        String name = "Name: " + MainActivity.sitter.getFirst()+ " "+ MainActivity.sitter.getLast();
        nameTV.setText(name);
        TextView addyTV = (TextView) findViewById(R.id.address);
        String addy = "Address: " + MainActivity.sitter.getAddress();
        addyTV.setText(addy);
        TextView cityStateZipTV = (TextView) findViewById(R.id.cityStateZip);
        String cityStateZip = MainActivity.sitter.getCity() + ", " + MainActivity.sitter.getState() + ", " + Integer.valueOf(MainActivity.sitter.getZip());
        cityStateZipTV.setText(cityStateZip);
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
        /*
         * TO DO!!
         */

    }


}
