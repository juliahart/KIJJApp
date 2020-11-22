package com.example.kijjapp;

import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class ThreadTaskCheckLogin extends Thread {
        private LoginActivity activity;
        private View view;

        public ThreadTaskCheckLogin(LoginActivity fromActivity, View view) {
            activity = fromActivity;
            this.view = view;
        }

        public void run( ) {
            // update View
            Log.w( "MA", "Inside run URL" );

               try {
            //create a URL
                   String email = MainActivity.email;
                   Log.w( "MA", "Email found: " );
                   URL url = new URL(LoginActivity.CheckLoginURL  + "?email=" +email);
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
              activity.isValidLogin(s,view);
              } catch( Exception e ) {
                Log.w( "MA", "exception Login check: " + e.getMessage() );
              }
        }
}
