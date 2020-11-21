package com.example.kijjapp;

import android.util.Log;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ThreadTaskUrl extends Thread {
    private MainActivity activity;

    public ThreadTaskUrl( MainActivity fromActivity ) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run URL" );

        try {
            //create a URL
            URL url = new URL(MainActivity.URL);
            // create an input stream for the URL
            InputStream is = url.openStream();
            // read from that input stream
            Scanner scan = new Scanner( is );
            String s = "";
            while( scan.hasNext( ) ) {
                s += scan.nextLine( );
            }
            activity.updateView(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception URL: " + e.getMessage() );
        }
    }
}