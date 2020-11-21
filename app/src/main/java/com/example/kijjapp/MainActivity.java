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

public class MainActivity extends AppCompatActivity {
    // W/MA: exception: Cleartext HTTP traffic to kijj.cs.loyola.edu not permitted (cant get to kijj) this is an issue!!!


    //public static final String URL = "http://klmatrangola.cs.loyola.edu/kijjTesting/testHi.php";

    //public static final String URL_GET = "http://klmatrangola.cs.loyola.edu/kijjTesting/testTest.php?klmatrangola@loyola.edu"; //name=Jill&age=20

  //  public static final String URL_JSON = "http://klmatrangola.cs.loyola.edu/kijjTesting/testJson.php";
   // public static final String URL_POST = "http://klmatrangola.cs.loyola.edu/kijjTesting/testPost.php";
    //public static final String URL = "http://hjfranceschi.cs.loyola.edu/cs489/hello.php";
   // public static final String URL_GET = "http://hjfranceschi.cs.loyola.edu/cs489/test.php?name=Jill&age=20";

   // public static final String URL_JSON = "http://hjfranceschi.cs.loyola.edu/cs489/json.php";
   // public static final String URL_POST = "http://hjfranceschi.cs.loyola.edu/cs489/testPost.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        
        // DO NOT TRY TO ACCESS THE THREAD RESULTS HERE (and update the View)
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