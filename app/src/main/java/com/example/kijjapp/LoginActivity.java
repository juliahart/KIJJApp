package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public static final String CheckLoginURL = "http://klmatrangola.cs.loyola.edu/kijjTesting/checkSitterLogin.php";
    //public static final String CheckLoginURL = "http://kijj.cs.loyola.edu/model/checkSitterLogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void doLogin(View view){
        Log.w("MA", "in doLogin");
        EditText emailET= (EditText) findViewById( R.id.username);
        String email = emailET.getText().toString();
        MainActivity.email = email;
        EditText passET= (EditText) findViewById( R.id.password);
        //check password later
        ThreadTaskCheckLogin taskCheck = new ThreadTaskCheckLogin(this, view);
        taskCheck.start();
    }

    /*
     * Method to go to the home view
     */
    public void goToHomePage(View view)
    {
        Intent intent = new Intent( this, HomeActivity.class );
        startActivity( intent );
    }

    /*
     * Method to go back to previous view (starting view)
     */
    public void goBack(View view){
        finish();
    }

    public void isValidLogin(String s, View view) {
        Log.w("MA", "in isValidLogin "+s);
        if(s.equals("true"))
        {
            goToHomePage(view);
        }
    }


}
