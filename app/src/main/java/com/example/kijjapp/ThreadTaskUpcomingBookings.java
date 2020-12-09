package com.example.kijjapp;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * This is the ThreadTaskUpcomingBookings Class
 * @authors: Team KIJJ
 */

public class ThreadTaskUpcomingBookings extends Thread{
    private UpcomingActivity activity;
    ListView listView;
    private View view;

    public ThreadTaskUpcomingBookings( UpcomingActivity fromActivity) {
        activity = fromActivity;
    }

    /**
     * Method to run upcoming bookings, connects to database
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void run( ) {
        // update View
        Log.w( "MA", "Inside run upcoming" );

        try {
            // create a URL
            URL url = new URL(UpcomingActivity.URL_upcomingInfo + "?email="+ MainActivity.email);
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
            activity.updateBookingsArray(s);
           // activity.createList(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception json: " + e.getMessage() );
        }
    }
}
