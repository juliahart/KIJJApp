package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LearnMoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        showProfile();
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

    public void showProfile(){
        String my_string = getIntent().getStringExtra("key".toString());
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
}
