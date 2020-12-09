package com.example.kijjapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
/**
 * This is the Custom Adapter Class for the list of upcoming bookings
 * it is used in the upcomingActivity class
 * @authors: Team KIJJ
 */
public class CustomListAdapter extends ArrayAdapter {
    private  final Activity context;

    //to store the list of countries
    private final String[] nameArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam) {

        super(context, R.layout.listview, nameArrayParam);
        this.context = context;
        this.nameArray = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"InflateParams", "ViewHolder"}) View rowView = inflater.inflate(R.layout.listview, null, true);

        //this code gets references to objects in the listview file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.name);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);

        return rowView;
    }
}


