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
    public static final String URL_JSON = "http://kijj.cs.loyola.edu/model/siterProfile.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.w( "MA", "Creating a ThreadTask object" );
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
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject1 = jsonArray.getJSONObject(1);
            first = jsonObject1.getString("first");
            last = jsonObject1.getString("last");
        } catch (JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
        TextView firstTV = (TextView) findViewById(R.id.first);
        firstTV.setText(first);

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
}
