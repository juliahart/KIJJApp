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

public class ThreadTaskPoints extends Thread {
    private UpcomingActivity activity;
    int points;
    //ListView listView;

    public ThreadTaskPoints(UpcomingActivity fromActivity, int points) {
        activity = fromActivity;
        this.points = points;
    }

    public void run() {
        // update View
        Log.w("MA", "Inside do apply");

        // try {
        // create a URL
        URL url = null;
        try {
            url = new URL(UpcomingActivity.URL_points + "?email=" + MainActivity.email + "&points=" + points) ;
            InputStream is = url.openStream();
            Log.w("MA", "Applied");


        } catch (Exception e) {
            e.printStackTrace();
            Log.w("MA", "Not applied");

        }
    }
}