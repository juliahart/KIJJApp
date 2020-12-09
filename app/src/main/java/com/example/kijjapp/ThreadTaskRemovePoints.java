package com.example.kijjapp;

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

/**
 * This is the ThreadTaskRemovePoints Class
 * @authors: Team KIJJ
 */

public class ThreadTaskRemovePoints extends Thread {
    private PointsActivity activity;
    int points;
    //ListView listView;

    public ThreadTaskRemovePoints(PointsActivity fromActivity, int points) {
        activity = fromActivity;
        this.points = points;
    }

    /**
     * Method to remove points, connects to database
     */
    public void run() {
        // update View
        Log.w("MA", "Inside do apply");

        // try {
        // create a URL
        URL url = null;
        try {
            url = new URL(PointsActivity.URL_points + "?email=" + MainActivity.email + "&points=" + points) ;
            InputStream is = url.openStream();
            Log.w("MA", "Applied");


        } catch (Exception e) {
            e.printStackTrace();
            Log.w("MA", "Not applied");

        }
    }
}