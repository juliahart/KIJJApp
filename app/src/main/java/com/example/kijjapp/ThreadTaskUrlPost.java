package com.example.kijjapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class ThreadTaskUrlPost extends Thread {

    private MainActivity activity;

    public ThreadTaskUrlPost( MainActivity fromActivity ) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run" );

        try {
            // create a URL
            URL url = new URL(MainActivity.URL_POST);
            // create a URLConnection
            URLConnection connection = url.openConnection();
            connection.setDoOutput( true );
            // get output stream
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter( os );
            osw.write( "name=Jane&age=21" );
            osw.flush();

            // create an input stream for the URL
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            // read from that input stream
            String line = "";
            String s = "";
            while( ( line = br.readLine() ) != null ) {
                s += line;
            }
            activity.updateView(s);
        } catch( Exception e ) {
            Log.w( "MA", "exception: " + e.getMessage() );
        }
    }
}


