package com.example.kijjapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public static final String URL = "http://kijj.cs.loyola.edu/model/homepage.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.w( "MA", "Creating a ThreadTask object" );
        //ThreadTask task = new ThreadTask( this );
        ThreadTaskUrl task = new ThreadTaskUrl( this );
        //ThreadTaskJsonUrl task = new ThreadTaskJsonUrl( this );
        //ThreadTaskUrlPost task = new ThreadTaskUrlPost( this );
        Log.w( "MA", "Start thread" );
        task.start( );
        Log.w( "MA", "Inside onCreate, Thread started" );
    }

    public void updateView( String s ) {
        Log.w( "MA", "Inside updateView" );
        TextView tv = (TextView) findViewById( R.id.newUser );
        tv.setText( s );

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
