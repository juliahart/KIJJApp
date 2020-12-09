package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This is the MainActivity Class
 * @authors: Team KIJJ
 */

public class MainActivity extends AppCompatActivity {
    public static final String URL_JSON = "http://kijj.cs.loyola.edu/model/sitterProfile.php";
    //public static final String URL_JSON = "http://klmatrangola.cs.loyola.edu/kijjTesting/siterProfile.php";
    public static String email;
    public static PetSitter sitter;
    public static PetOwner owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    /**
     * checks that the login is valid
     * @param s login string
     * @param view the view
     */
    public void isValidLogin(String s, View view)
    {
        if(s.equals("true"))
        {
            goToLoginPage(view);
        }
    }

    /**
     * Method to go to login view
     */
    public void goToLoginPage(View view){

        Intent intent = new Intent( this, LoginActivity.class );
        startActivity( intent );
    }

    /**
     * Method to go to sign up view
     */
    public void goToSignUp(View view)
    {
        Intent intent = new Intent( this, SignUpActivity.class );
        startActivity( intent );
    }


}