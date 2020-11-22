package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    //
    // ISSUE : LOGS IN IF FIELDS ARE EMPTY
    //
    public static final String CheckLoginURL = "http://klmatrangola.cs.loyola.edu/kijjTesting/checkSitterLogin.php";
    //public static final String CheckLoginURL = "http://kijj.cs.loyola.edu/model/checkSitterLogin.php";

    //public static final String URL_JSON = "http://kijj.cs.loyola.edu/model/sitterProfile.php";
    public static final String URL_JSON = "http://klmatrangola.cs.loyola.edu/kijjTesting/siterProfile.php";
    private String pass;
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
        pass = passET.getText().toString();
        //check password later
        ThreadTaskCheckLogin taskCheck = new ThreadTaskCheckLogin(this, view);
        taskCheck.start();
    }

    public void updateSitterWithJSON( String json, View view ) {
        Log.w("MA", "Inside updateViewWithJson");
        String first="";
        String last="";
        String address = "";
        String city = "";
        String state = "";
        int zip;
        double lat;
        double longi;
        int points;
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject0 = jsonArray.getJSONObject(0);

            //get all the info
            first = jsonObject0.getString("first");
            Log.w("MA", "firstName: "+first);

            last = jsonObject0.getString("last");
            address = jsonObject0.getString("address");
            city = jsonObject0.getString("city");
            state = jsonObject0.getString("state");
            zip = jsonObject0.getInt("zip");
            lat = jsonObject0.getDouble("lat");
            longi = jsonObject0.getDouble("long");
            points = jsonObject0.getInt("points");

            MainActivity.sitter = new PetSitter(MainActivity.email,first,last,address,city,state,zip,lat,longi,points);
            MainActivity.sitter.setEmail(MainActivity.email);
            goToHomePage(view);



        } catch (JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }



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
            //update sitter info

            ThreadTaskJsonUrl sitterInfo = new ThreadTaskJsonUrl(this,view);
            sitterInfo.start();
            //go to homepage
        }

    }


    public String getPass() {
        return pass;
    }
}
