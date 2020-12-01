package com.example.kijjapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.ArrayList;

public class NewBookingsActivity extends AppCompatActivity {

    private TextView tv;
    private SeekBar seekBar;
    private String breed;
    //public static final String URL_bookingInfo = "http://kijj.cs.loyola.edu/model/getValidBookings.php";
    public static final String URL_bookingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/getValidBookings.php";
    private ArrayList<Booking> validBookingsList = new ArrayList<>();
    private ArrayList<Booking> allBookingsList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbooking);
        seekBar = findViewById(R.id.distance_bar);
        tv = findViewById(R.id.distanceView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv.setText(String.valueOf(seekBar.getProgress()) + " mi");
            }
        });
    }

    /**
     * Method to go to profile view
     */
    public void goToProfile(View view) {
        Intent intent = new Intent(this, LearnMoreActivity.class);
        startActivity(intent);
    }

    /**
     * Method to go to new back to previous view (home)
     */
    public void goBack(View view) {
        finish();
    }

    /**
     * method to search for filtered bookings
     */
    public void search(View view) {

        EditText breedET = (EditText) findViewById(R.id.checkBox4);
        validBookingsList = allBookingsList;
        if(breedET.getText().toString().trim().length() > 0)
        {
            breed = breedET.getText().toString();
        }
        else{
            breed = "blank";
        }
        Log.w("MA", "Breed="+breed);
        ThreadTaskAllBookings taskAllBookings = new ThreadTaskAllBookings(this);
        taskAllBookings.start();
        Log.w("MA", "searching...");
    }

    public void updateAllBookings(String s) {
        ListView seatchListView;
        seatchListView = (ListView) findViewById(R.id.SearchListView);


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
                        bookingi.getString("start"), bookingi.getString("end"), bookingi.getString(("status")));




                validBookingsList.add(tempBooking);




                // This only outputs 1 booking ( I think that it might not retrieve all the bookings
                // the size of bookingsList is 1)
                //doesnt work for kijj forgot to change php there
                //exception json: Only the original thread that created a view hierarchy can touch its views.

            }

        } catch (
                JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }

        //boolean a = findValidBookings();

        Log.w("MA", "now Have: " + validBookingsList.size());

        String [] test = new String[validBookingsList.size()];
        for (int j = 0; j < validBookingsList.size(); j++)
        {
            Log.w("MA", "booking id: "+ validBookingsList.get(j).getId());
            startDate = validBookingsList.get(j).getStartDate();
            endDate = validBookingsList.get(j).getStartDate();
            name = validBookingsList.get(j).getPetOwner().getPetName();
            type = validBookingsList.get(j).getPetOwner().getType();
            String stat = validBookingsList.get(j).getStatus();
            //error here?
            //String list
            //test = new String[]{String.valueOf(bookingsList.size()), "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate, "test"};
            test[j] =  "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nStatus: " + stat;
            Log.w("MA", "booking String: " + "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate+ "\nStatus: " + stat);
            //error here
        }
        CustomListAdapter whatever = new CustomListAdapter(this, test);
        seatchListView.setAdapter(whatever);


    }

    public boolean findValidBookings() {

        Log.w("MA", "looking for valid things");
        EditText breedET = (EditText) findViewById(R.id.checkBox4);
        validBookingsList = allBookingsList;

        for (int i = 0; i < allBookingsList.size(); i++) {
            //see if closed
            if (validBookingsList.get(i).getStatus().equals("closed")) {
                validBookingsList.remove(validBookingsList.get(i));
                Log.w("MA", "removing closed: " + allBookingsList.get(i).getId());
            }
            //see if type is input

            //see if breed is input
            else if (breedET.getText().toString().trim().length() > 0) {
                if (!breedET.getText().toString().toLowerCase().equals(validBookingsList.get(i).getPetOwner().getBreed().toLowerCase())) {
                    validBookingsList.remove(validBookingsList.get(i));
                    Log.w("MA", "removing" + allBookingsList.get(i).getId() + ", looking for: "+ breedET.getText().toString().toLowerCase() + "  breed: " + validBookingsList.get(i).getPetOwner().getBreed().toLowerCase() );

                }
            }
            //see if rating is input

            //see if rating is input

            //see if distance is input
        }
        Log.w("MA", "now Have: " + validBookingsList.size());

        return true;
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

