package com.example.kijjapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OwnerProfileActivity extends AppCompatActivity {

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerprofile);
        showProfile();


    }

    public void showProfile(){
    }



    /**
     * method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }
}
