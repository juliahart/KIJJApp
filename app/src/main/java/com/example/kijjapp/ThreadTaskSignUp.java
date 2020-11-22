package com.example.kijjapp;

import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ThreadTaskSignUp extends Thread {
        private SignUpActivity activity;
        private View view;


        public ThreadTaskSignUp(SignUpActivity fromActivity, View view) {
            activity = fromActivity;
            this.view=view;
        }

        public void run( ) {
            // update View
            Log.w( "MA", "Inside run Signup" );

            try {
                //create a URL
                String email = MainActivity.sitter.getEmail();
                String pass = activity.getPass();
                String addy = MainActivity.sitter.getAddress();
                String first = MainActivity.sitter.getFirst();
                String last = MainActivity.sitter.getLast();
                String city = MainActivity.sitter.getCity();
                String zip = String.valueOf(MainActivity.sitter.getZip());
                String state = MainActivity.sitter.getState();

                URL url = new URL(SignUpActivity.SignupURL + "?first="+first+"&last="+last+"&address="+addy+"&city="+city+"&state="+state+"&zip="+zip+ "&email=" +email +"&pass="+pass);
                Log.w("MA", "signup url:" + url);
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
                activity.addLatLongToSitter(s, view);
            } catch( Exception e ) {
                Log.w( "MA", "exception signup: " + e.getMessage() );
            }
        }
}
