package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    /*
     * Method to go to login view
     */
    public void goToLoginPage(View view){
        Intent intent = new Intent( this, LoginActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go to sign up view
     */
    public void goToSignUp(View view)
    {
        Intent intent = new Intent( this, SignUpActivity.class );
        startActivity( intent );
    }
}