package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UpcomingActivity extends AppCompatActivity {
    public static final String URL_upcomingInfo = "http://kijj.cs.loyola.edu/model/bookingInfo.php";
    //public static final String URL_upcomingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/bookingInfo.php";



    private ArrayList<Booking> bookingsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ThreadTaskUpcomingBookings taskUpcomingBookings = new ThreadTaskUpcomingBookings(this);
        taskUpcomingBookings.start();

        //NEED TO CHECK & SEE IF THIS WORKS!!
        updateBookingsArray(URL_upcomingInfo);
        TextView bookingTV = (TextView) findViewById(R.id.booking);
        setTextViewValues(bookingsList, bookingTV);

    }

    /*
     * Method to go to profile view
     */
    public void goToProfile(View view){
        Intent intent = new Intent( this, ProfileActivity.class );
        // go to home screen
        startActivity( intent );
    }


    /*
     * Method to go back to previous view
     */
    public void goBack(View view){
            finish();
    }

    public void updateBookingsArray(String s) {
        try{
        JSONArray jsonArray = new JSONArray(s);
        int numBookings = jsonArray.length();
        for(int i = 0; i < numBookings; i++)
        {
            JSONObject jsonObjecti = jsonArray.getJSONObject(i);
            Log.w("MA", "jArri: "+ jsonObjecti);
            JSONObject bookingi = jsonObjecti.getJSONObject("booking");
            JSONObject owneri = jsonObjecti.getJSONObject("owner");
            PetOwner tempOwner = new PetOwner(bookingi.getString("ownerEmail"), owneri.getString("first"), owneri.getString("last"),
                    owneri.getString("address"), owneri.getString("city"), owneri.getString("state"), owneri.getInt("zip"),
                    owneri.getDouble("lat"), owneri.getDouble("long"), owneri.getString("desc"), owneri.getString("type"),
                    owneri.getString("breed"), owneri.getString("petName"));
            Booking tempBooking = new Booking(bookingi.getInt("id"), MainActivity.sitter, tempOwner,
                    bookingi.getString("start"), bookingi.getString("end"));
            bookingsList.add(tempBooking);
        }
        //View needed for each booking...
         //   TextView bookingTV = (TextView) findViewById(R.id.booking);
         //   setTextViewValues(bookingsList, bookingTV);

        } catch (
            JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
    }

    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }

    /**
    * This should take the arraylist and put it into a string and onto the textView, but need php to check
     * TO DO!!!! CHECK THIS!!!!
     */
    public void setTextViewValues (ArrayList<Booking> vals, TextView text) {
        //Variable to hold all the values
        String output = "";

        for (int i = 0; i < vals.size(); i++) {
            //Append all the values to a string
            output += vals.get(i);
        }
        //Set the textview to the output string
        text.setText(output);
    }

    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
}
