package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class OwnerProfileActivity extends AppCompatActivity {

    UpcomingActivity activity;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerprofile);
        showProfile();

    }



    public void showProfile(){
        TextView nameTV = (TextView) findViewById(R.id.name);
      //  String name = "Name: " + Arrays.toString(activity.ownerInfo);
      //  nameTV.setText(name);
    }



    /**
     * method to go back to previous view
     */
    public void goBack(View view)
    {
        finish();
    }
}
