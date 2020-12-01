package com.example.kijjapp;

import android.app.AutomaticZenRule;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private String email;

    Button b;
    EditText editText;
    EditText editAdd;
    EditText editZip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        showProfile();
        editText = (EditText) findViewById(R.id.name);
        editAdd = (EditText) findViewById(R.id.address);
        editZip = (EditText) findViewById(R.id.cityStateZip);
        b = (Button)findViewById(R.id.saveProfile);

        editText.setEnabled(false);
        editAdd.setEnabled(false);
        editZip.setEnabled(false);

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

    /**
    * method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }


    /**
     * TO DO!!
     */
    public void editProfile(View view)
    {
        editText.setEnabled(true);
        editText.requestFocus();
        editAdd.setEnabled(true);
        editAdd.requestFocus();
        editZip.setEnabled(true);
        editZip.requestFocus();

        b.setVisibility(View.VISIBLE);

    }
    public void save(View view)
    {
        editText.setEnabled(false);
        editAdd.setEnabled(false);
        editZip.setEnabled(false);
        b.setVisibility(View.INVISIBLE);

    }


}
