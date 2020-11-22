package com.example.kijjapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private String email;
    //public static final String URL_JSON = "http://kijj.cs.loyola.edu/model/sitterProfile.php";
    public static final String URL_JSON = "http://klmatrangola.cs.loyola.edu/kijjTesting/siterProfile.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        email = MainActivity.email;
        Log.w( "MA", "Creating a ThreadTask object" );
        Log.w( "MA", "email = " + email);

        //ThreadTask task = new ThreadTask( this );
      //  ThreadTaskUrl task = new ThreadTaskUrl( this );
        ThreadTaskJsonUrl task = new ThreadTaskJsonUrl( this );
        //ThreadTaskUrlPost task = new ThreadTaskUrlPost( this );
        Log.w( "MA", "Start thread" );
        task.start( );
        Log.w( "MA", "Inside onCreate, Thread started" );
    }

    public void updateViewWithJson( String json ) {
        Log.w("MA", "Inside updateViewWithJson");
        String first="";
        String last="";
        String address = "";
        String city = "";
        String state = "";
        String zip = "";
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject0 = jsonArray.getJSONObject(0);
            first = jsonObject0.getString("first");
            last = jsonObject0.getString("last");
            address = jsonObject0.getString("address");
            city = jsonObject0.getString("city");
            state = jsonObject0.getString("state");
            zip = jsonObject0.getString("zip");

        } catch (JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
        TextView nameTV = (TextView) findViewById(R.id.name);
        String name = "Name: " + first+ " "+ last;
        nameTV.setText(name);
        TextView addyTV = (TextView) findViewById(R.id.address);
        String addy = "Address: " + address;
        addyTV.setText(addy);
        TextView cityStateZipTV = (TextView) findViewById(R.id.cityStateZip);
        String cityStateZip = city + ", " + state + ", " +zip;
        cityStateZipTV.setText(cityStateZip);


    }
    /*
    * method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }


    /*
     * TO DO!!
     */
    public void editProfile(View view)
    {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
