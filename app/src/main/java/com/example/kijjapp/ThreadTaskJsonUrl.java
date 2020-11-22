package com.example.kijjapp;

import android.util.Log;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ThreadTaskJsonUrl extends Thread {
    private ProfileActivity activity;

    public ThreadTaskJsonUrl( ProfileActivity fromActivity ) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run JSON" );

        try {
            // create a URL
            URL url = new URL(ProfileActivity.URL_JSON + "?email="+ MainActivity.email);
            // create an input stream for the URL
            InputStream is = url.openStream();
            // read from that input stream
            Scanner scan = new Scanner( is );
            String s = "";
            while( scan.hasNext( ) ) {
                s += scan.nextLine( );

                // s is expected to be a JSON string
            }
            activity.updateViewWithJson(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception json: " + e.getMessage() );
        }
    }
}

