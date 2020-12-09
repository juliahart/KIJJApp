package com.example.kijjapp;

/**
 * This is the ThreadTaskDoApply Class
 * @authors: Team KIJJ
 */

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.kijjapp.MainActivity;
import com.example.kijjapp.ProfileActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ThreadTaskDoApply extends Thread {
    private NewBookingsActivity activity;
    int bookingId;
    //ListView listView;

    public ThreadTaskDoApply(NewBookingsActivity fromActivity, int bookingId) {
        activity = fromActivity;
        this.bookingId = bookingId;
    }

    /**
     * Method to run  apply, connects to database
     */
    public void run() {
        // update View
        Log.w("MA", "Inside do apply");

        // try {
        // create a URL
        URL url = null;
        try {
            url = new URL(NewBookingsActivity.URL_doApply + "?sitterEmail=" + MainActivity.email + "&bookingId=" + bookingId);
            InputStream is = url.openStream();
            Log.w("MA", "Applied");


        } catch (Exception e) {
            e.printStackTrace();
            Log.w("MA", "Not applied");

        }
    }
}