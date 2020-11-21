package com.example.kijjapp;

import android.util.Log;

public class ThreadTask extends Thread {
    private ProfileActivity activity;

    public ThreadTask( ProfileActivity fromActivity ) {
        activity = fromActivity;
    }

    public void run( ) {
        // update View
        Log.w( "MA", "Inside run ThreadTask" );
        String s = "CHANGED from THREAD";
       // activity.updateView( s );
    }


}