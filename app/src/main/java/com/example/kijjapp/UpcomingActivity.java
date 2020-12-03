package com.example.kijjapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class UpcomingActivity extends AppCompatActivity {
    // public static final String URL_upcomingInfo = "http://kijj.cs.loyola.edu/model/bookingInfo.php";
    public static final String URL_upcomingInfo = "http://klmatrangola.cs.loyola.edu/kijjTesting/bookingInfo.php";

    String[] sd;
    String[] ed;
    int length;
    private ArrayList<Booking> bookingsList = new ArrayList<>();
    String[] ownerInfo;
    String[] ownerAddress;
    String[] ownerZCS;

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
    public void goToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        // go to home screen
        startActivity(intent);
    }


    /**
     * Method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }

    @SuppressLint("SetTextI18n")
    public void updateBookingsArray(String s) {

        final ListView listView;
        listView = (ListView) findViewById(R.id.listView);


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
                        owneri.getDouble("lat"), owneri.getDouble("long"), owneri.getString("desc"), owneri.getDouble("rating"), owneri.getString("type"),
                        owneri.getString("breed"), owneri.getString("petName"));

                Booking tempBooking = new Booking(bookingi.getInt("id"), MainActivity.sitter, tempOwner,
                        bookingi.getString("start"), bookingi.getString("end"), bookingi.getString("status"));


                bookingsList.add(tempBooking);


                // This only outputs 1 booking ( I think that it might not retrieve all the bookings
                // the size of bookingsList is 1)
                //doesnt work for kijj forgot to change php there
                //exception json: Only the original thread that created a view hierarchy can touch its views.


            }
            final String[] test = new String[bookingsList.size()];

            ownerInfo = new String[bookingsList.size()];
            ownerAddress = new String[bookingsList.size()];
            ownerZCS = new String[bookingsList.size()];
            for (int j = 0; j < bookingsList.size(); j++) {
                Log.w("MA", "booking id: " + bookingsList.get(j).getId());
                startDate = bookingsList.get(j).getStartDate();
                endDate = bookingsList.get(j).getEndDate();
                name = bookingsList.get(j).getPetOwner().getPetName();
                type = bookingsList.get(j).getPetOwner().getType();
                //error here?
                //String list

                //test = new String[]{String.valueOf(bookingsList.size()), "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate, "test"};
                test[j] = "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate;
                Log.w("MA", "booking String: " + "Name: " + name + "\nType: " + type + "\nStart Date: " + startDate + "\nEnd Date: " + endDate + "test");
                //error here


                //this is not working yet!!
                sd = startDate.split("-");
                ed = startDate.split("-");
                length = Integer.parseInt(sd[1]) - Integer.parseInt(this.ed[1]);

                ownerInfo[j] = bookingsList.get(j).getPetOwner().getFirst() + " " + bookingsList.get(j).getPetOwner().getLast();
                ownerAddress[j] = bookingsList.get(j).getPetOwner().getAddress();
                ownerZCS[j] = bookingsList.get(j).getPetOwner().getCity() + ", " + bookingsList.get(j).getPetOwner().getState() + ", "
                        + bookingsList.get(j).getPetOwner().getZip();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    CustomListAdapter whatever = new CustomListAdapter((Activity) listView.getContext(), test);
                    listView.setAdapter(whatever);
                }
            });


        } catch (
                JSONException jsone) {
            Log.w("MA", "JSON exception: " + jsone.getMessage());
        }
    }


    public String getBookingsList() {
        return bookingsList.toString();
    }


    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }

    public void goToOwnerProfile(View view) {
        Intent intent = new Intent(UpcomingActivity.this,OwnerProfileActivity.class);
        intent.putExtra("key", Arrays.toString(ownerInfo));
        intent.putExtra("key2", Arrays.toString(ownerAddress));
        intent.putExtra("key3", Arrays.toString(ownerZCS));
        startActivity(intent);
    }

    //This is not working yet
    public void finished(View view) {
        MainActivity.sitter.addPoints(length);
    }


}

