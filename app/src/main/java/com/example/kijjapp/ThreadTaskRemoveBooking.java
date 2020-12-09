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
 * This is the ThreadTaskRemoveBooking Class
 * @authors: Team KIJJ
 */

public class ThreadTaskRemoveBooking extends Thread {
    private UpcomingActivity activity;
    int id;
    //ListView listView;

    public ThreadTaskRemoveBooking(UpcomingActivity fromActivity, int id) {
        activity = fromActivity;
        this.id = id;
    }

    /**
     * Method to remove booking, connects to database
     */
    public void run() {
        // update View
        Log.w("MA", "Inside do apply");

        // try {
        // create a URL
        URL url = null;
        try {
            url = new URL(UpcomingActivity.URL_removeBooking + "?bookingId=" + id);
            InputStream is = url.openStream();
            Log.w("MA", "removed");


        } catch (Exception e) {
            e.printStackTrace();
            Log.w("MA", "Not removed");

        }
    }
}