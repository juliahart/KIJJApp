package com.example.kijjapp;
import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class ThreadTaskPoints extends Thread {
    private PointsActivity activity;
    private View view;

    public ThreadTaskPoints(PointsActivity fromActivity) {
        activity = fromActivity;
        this.view = view;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run URL POINTS" );

        try {
            //create a URL
            String email = MainActivity.email;
            URL url = new URL(PointsActivity.PointsURL  + "?email=" +email);
            URLConnection connection = url.openConnection();
            connection.setDoOutput( true );
            // create an input stream for the URL
            InputStream is = url.openStream();
            // read from that input stream
            Scanner scan = new Scanner( is );
            String s = "";
            while( scan.hasNext( ) ) {
                s += scan.nextLine( );
            }
            activity.updatePointsView(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception URL: " + e.getMessage() );
        }
    }
}
