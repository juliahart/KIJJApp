package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignUpActivity extends AppCompatActivity {
    private String pass;
  //  public static final String SignupURL = "http://klmatrangola.cs.loyola.edu/kijjTesting/sitterSignup.php";
    public static final String SignupURL = "http://kijj.cs.loyola.edu/model/sitterSignup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void doSignUP(View view){
        EditText emailEt = (EditText) findViewById( R.id.username);
        String email = emailEt.getText().toString();
        EditText passET= (EditText) findViewById( R.id.password);
        pass = passET.getText().toString();
        EditText firstET = (EditText) findViewById( R.id.first);
        String first = firstET.getText().toString();
        EditText lastEt = (EditText) findViewById( R.id.last);
        String last = lastEt.getText().toString();
        EditText addressET = (EditText) findViewById( R.id.address);
        String address = addressET.getText().toString();
        EditText cityET = (EditText) findViewById( R.id.city);
        String city = cityET.getText().toString();
        EditText stateET = (EditText) findViewById( R.id.state);
        String state = stateET.getText().toString();
        EditText zipET = (EditText) findViewById( R.id.zip);
        int zip = Integer.valueOf(zipET.getText().toString());

        MainActivity.sitter = new PetSitter();
        MainActivity.sitter.setEmail(email);
        MainActivity.sitter.setFirst(first);
        MainActivity.sitter.setLast(last);
        MainActivity.sitter.setAddress(address);
        MainActivity.sitter.setCity(city);
        MainActivity.sitter.setState(state);
        MainActivity.sitter.setZip(zip);
        MainActivity.sitter.setPoints(0);
        ThreadTaskSignUp taskSignUp = new ThreadTaskSignUp(this, view);
        taskSignUp.start();
    }

    /**
     * Method to go to home page
     */
    public void goToHomePage(View view)
    {
        Intent intent = new Intent( this, HomeActivity.class );
        startActivity( intent );
    }

    /**
     * Method to go back to previous view
     */
    public void goBack(View view){
        finish();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void addLatLongToSitter(String json, View view) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject0 = jsonArray.getJSONObject(0);

            //get all the info
            double lat = jsonObject0.getDouble("lat");
            double longi = jsonObject0.getDouble("long");
            MainActivity.sitter.setLat(lat);
            MainActivity.sitter.setLongi(longi);
            Log.w("MA", "going to home page");

            goToHomePage(view);
        } catch (
    JSONException jsone) {
        Log.w("MA", "JSON exception: " + jsone.getMessage());
    }
    }
}
