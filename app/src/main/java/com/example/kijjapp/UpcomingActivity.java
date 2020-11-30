package com.example.kijjapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UpcomingActivity extends AppCompatActivity {
    //public static final String URL_upcomingInfo = "http://kijj.cs.loyola.edu/model/bookingInfo.php";
    public static final String URL_upcomingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/bookingInfo.php";

    ListView listView;
  //  private ArrayAdapter<String> listAdapter ;


    private ArrayList<Booking> bookingsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ThreadTaskUpcomingBookings taskUpcomingBookings = new ThreadTaskUpcomingBookings(this);
        taskUpcomingBookings.start();

        //String [] test;
       // test = new String[]{"mary", "john"};
        //CustomListAdapter whatever = new CustomListAdapter(this, test);
        listView = (ListView) findViewById(R.id.listView);

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
        try {

            Log.w("MA", "All of them: " + s);
            JSONArray jsonArray = new JSONArray(s);
            int numBookings = jsonArray.length();
            Log.w("MA", "num Bookings: " + numBookings);
            for (int i = 0; i < numBookings; i++) {

                // JSONObject jsonObjecti = jsonArray.getJSONArray(i);
                JSONObject jsonObji = new JSONObject(jsonArray.getString(i));
                String bookingi_str = jsonObji.getString("booking");

                JSONObject bookingi = new JSONObject(bookingi_str);

                JSONObject owneri = jsonObji.getJSONObject("owner");

                PetOwner tempOwner = new PetOwner(bookingi.getString("ownerEmail"), owneri.getString("first"), owneri.getString("last"),
                        owneri.getString("address"), owneri.getString("city"), owneri.getString("state"), owneri.getInt("zip"),
                        owneri.getDouble("lat"), owneri.getDouble("long"), owneri.getString("desc"), owneri.getString("type"),
                        owneri.getString("breed"), owneri.getString("petName"));

                Booking tempBooking = new Booking(bookingi.getInt("id"), MainActivity.sitter, tempOwner,
                        bookingi.getString("start"), bookingi.getString("end"));




                bookingsList.add(tempBooking);


                // This only outputs 1 booking ( I think that it might not retrieve all the bookings
                // the size of bookingsList is 1)
                //doesnt work for kijj forgot to change php there
                //exception json: Only the original thread that created a view hierarchy can touch its views.

            }
            for (int j = 0; j < bookingsList.size(); j++)
            {
                Log.w("MA", "booking id: "+ bookingsList.get(j).getId());
                startDate = bookingsList.get(j).getStartDate();
                endDate = bookingsList.get(j).getStartDate();
                name = bookingsList.get(j).getPetOwner().getPetName();
                type = bookingsList.get(j).getPetOwner().getType();
                Log.w("MA", "booking String: " + "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate+ "test");
            }


            Log.w("MA","New spot" );
            String [] test = new String[bookingsList.size()];
            for (int j = 0; j < bookingsList.size(); j++)
            {
                Log.w("MA", "booking id: "+ bookingsList.get(j).getId());
                startDate = bookingsList.get(j).getStartDate();
                endDate = bookingsList.get(j).getStartDate();
                name = bookingsList.get(j).getPetOwner().getPetName();
                type = bookingsList.get(j).getPetOwner().getType();
                //error here?
                //String list
                //test = new String[]{String.valueOf(bookingsList.size()), "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate, "test"};
                test[j] =  "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate;
                Log.w("MA", "booking String: " + "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate+ "test");
                //error here
            }
            CustomListAdapter whatever = new CustomListAdapter(this, test);
            listView.setAdapter(whatever);
        } catch (
            JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
    }


    public String getBookingsList()
    {
        return bookingsList.toString();
    }


    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
}
