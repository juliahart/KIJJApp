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


    //public static final String URL = "https://klmatrangola.cs.loyola.edu/kijjTesting/testHi.php";

    //public static final String URL_GET = "https://klmatrangola.cs.loyola.edu/kijjTesting/testTest.php?klmatrangola@loyola.edu"; //name=Jill&age=20

    //public static final String URL_JSON = "https://klmatrangola.cs.loyola.edu/kijjTesting/testJson.php";
    //public static final String URL_POST = "https://klmatrangola.cs.loyola.edu/kijjTesting/testPost.php";
    public static final String URL = "http://hjfranceschi.cs.loyola.edu/cs489/hello.php";
    public static final String URL_GET = "http://hjfranceschi.cs.loyola.edu/cs489/test.php?name=Jill&age=20";

    public static final String URL_JSON = "http://hjfranceschi.cs.loyola.edu/cs489/json.php";
    public static final String URL_POST = "http://hjfranceschi.cs.loyola.edu/cs489/testPost.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.w( "MA", "Creating a ThreadTask object" );
       // ThreadTask task = new ThreadTask( this );
        ThreadTaskUrl task = new ThreadTaskUrl( this );
         //ThreadTaskJsonUrl task = new ThreadTaskJsonUrl( this );
        //ThreadTaskUrlPost task = new ThreadTaskUrlPost( this );
        Log.w( "MA", "Start thread" );
        task.start( );
        Log.w( "MA", "Inside onCreate, Thread started" );
        // DO NOT TRY TO ACCESS THE THREAD RESULTS HERE (and update the View)
    }

    public void updateView( String s ) {
        Log.w( "MA", "Inside updateView" );
        TextView tv = (TextView) findViewById( R.id.newUser );
        tv.setText( s );

    }

    public void updateViewWithJson( String json ) {
        Log.w( "MA", "Inside updateViewWithJson" );
        String s = "";
        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObject1 = jsonArray.getJSONObject( 1 );
            String name = jsonObject1.getString( "name" );
            int age = jsonObject1.getInt( "age" );
            s = name + " " + age;
        } catch( JSONException jsone ) {
            Log.w( "MA", "JSON exception: " + jsone.getMessage() );
        }
        TextView tv = (TextView) findViewById( R.id.newUser);
        tv.setText( s );

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