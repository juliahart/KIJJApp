package com.example.kijjapp;

import android.annotation.SuppressLint;
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
    //public static final String URL_upcomingInfo = "http://kijj.cs.loyola.edu/model/bookingInfo.php";
    public static final String URL_upcomingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/bookingInfo.php";



    private ArrayList<Booking> bookingsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ThreadTaskUpcomingBookings taskUpcomingBookings = new ThreadTaskUpcomingBookings(this);
        taskUpcomingBookings.start();

    }

    /**
     * Method to go to profile view
     */
    public void goToProfile(View view){
        Intent intent = new Intent( this, ProfileActivity.class );
        // go to home screen
        startActivity( intent );
    }


    /**
     * Method to go back to previous view
     */
    public void goBack(View view){
            finish();
    }

    @SuppressLint("SetTextI18n")
    public void updateBookingsArray(String s) {
        String endDate = null;
        String startDate = null;
        String name = null;
        String type = null;
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

            startDate  = tempBooking.getStartDate();
            endDate = tempBooking.getStartDate();
            name  = tempOwner.getFirst();
            type = tempOwner.getType();

            bookingsList.add(tempBooking);

        }
        //View needed for each booking...
           for(int i = 0; i < bookingsList.size(); i++)
            {
                TextView tv = (TextView) findViewById( R.id.booking );
                tv.setText("Name: " + name + ", Type: " + type + ", start date: " + startDate + ", end date: " + endDate);
           }


        } catch (
            JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
    }

    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }


    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
}
