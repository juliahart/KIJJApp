package com.example.kijjapp;

import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


import android.util.Log;


public class ThreadTaskAllBookings extends Thread{
    private NewBookingsActivity activity;
    ListView listView;

    public ThreadTaskAllBookings( NewBookingsActivity fromActivity) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run upcoming" );

        try {
            // create a URL
            URL url = new URL(NewBookingsActivity.URL_bookingInfo + "?breed="+activity.getBreed());
            // create an input stream for the URL
            InputStream is = url.openStream();
            // read from that input stream
            Scanner scan = new Scanner( is );
            String s = "";
            while( scan.hasNext( ) ) {
                s += scan.nextLine( );

                // s is expected to be a JSON string
            }
            // Log.w("booking Array: ", s);
            activity.updateAllBookings(s);
            // activity.createList(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception json: " + e.getMessage() );
        }
    }
}
