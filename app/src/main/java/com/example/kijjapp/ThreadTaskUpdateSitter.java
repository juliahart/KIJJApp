package com.example.kijjapp;


import android.util.Log;
        import android.view.View;
        import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
        import java.util.Scanner;

public class ThreadTaskUpdateSitter extends Thread{
    private ProfileActivity activity;
    //ListView listView;

    public ThreadTaskUpdateSitter( ProfileActivity fromActivity) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run upcoming" );

       // try {
            // create a URL
        URL url = null;
        try {
            url = new URL(ProfileActivity.URL_updateSitter + "?email="+ MainActivity.email + "&first="+MainActivity.sitter.getFirst() + "&last="+MainActivity.sitter.getLast()
                    + "&address=" + MainActivity.sitter.getAddress() + "&city=" + MainActivity.sitter.getCity() + "&state=" + MainActivity.sitter.getState() + "&zip=" + MainActivity.sitter.getZip());
            InputStream is = url.openStream();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // create an input stream for the URL

        // read from that input stream
            //Scanner scan = new Scanner( is );
            //String s = "";
            //while( scan.hasNext( ) ) {
            //    s += scan.nextLine( );

                // s is expected to be a JSON string
           // }
            // Log.w("booking Array: ", s);
            //activity.updateSitterInfo();//s);
            // activity.createList(s);
       // } catch( Exception e ) {
        //    Log.w( "MA", "exception json: " + e.getMessage() );
       // }
    }
}
