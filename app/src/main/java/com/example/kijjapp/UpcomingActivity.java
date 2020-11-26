package com.example.kijjapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UpcomingActivity extends AppCompatActivity {
    //public static final String URL_upcomingInfo = "http://kijj.cs.loyola.edu/model/bookingInfo.php";
    public static final String URL_upcomingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/bookingInfo.php";

    ListView listView;
    private ArrayAdapter<String> listAdapter ;


    private ArrayList<Booking> bookingsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        ThreadTaskUpcomingBookings taskUpcomingBookings = new ThreadTaskUpcomingBookings(this);
        taskUpcomingBookings.start();


    }

   public void createList(String s)
    {
        CustomListAdapter whatever = new CustomListAdapter(this, new String[]{s});
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(whatever);
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
            Log.w("MA", "All of them: "+ s);
            JSONArray jsonArray = new JSONArray(s);
            int numBookings = jsonArray.length();
            Log.w("MA", "num Bookings: "+numBookings);
        for(int i = 0; i < numBookings; i++)
        {
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


            startDate  = tempBooking.getStartDate();
            endDate = tempBooking.getStartDate();
            name  = tempOwner.getFirst();
            type = tempOwner.getType();

            // This only outputs 1 booking .... will need to use ListView
            //

            TextView textView = (TextView) findViewById(R.id.booking);
            if(textView != null) {
                textView.setText("Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate);
            }

           bookingsList.add(tempBooking);

        }
        //View needed for each booking...

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
