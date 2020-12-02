package com.example.kijjapp;

import android.app.AutomaticZenRule;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private String email;
    //public static final String URL_updateSitter = "http://kijj.cs.loyola.edu/model/sitterChangeProfile.php";
    public static final String URL_updateSitter = "http://klmatrangola.cs.loyola.edu/kijjTesting/sitterChangeProfile.php";

    Button b;
    EditText editText;
    EditText editAdd;
    EditText editZip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        showProfile();
        editText = (EditText) findViewById(R.id.name);
        editAdd = (EditText) findViewById(R.id.address);
        editZip = (EditText) findViewById(R.id.cityStateZip);
        b = (Button)findViewById(R.id.saveProfile);

        editText.setEnabled(false);
        editAdd.setEnabled(false);
        editZip.setEnabled(false);

    }

    public void showProfile(){
        TextView nameTV = (TextView) findViewById(R.id.name);
        String name = "Name: " + MainActivity.sitter.getFirst()+ " "+ MainActivity.sitter.getLast();
        nameTV.setText(name);

        TextView addyTV = (TextView) findViewById(R.id.address);
        String addy = "Address: " + MainActivity.sitter.getAddress();
        addyTV.setText(addy);

        TextView cityStateZipTV = (TextView) findViewById(R.id.cityStateZip);
        String cityStateZip = MainActivity.sitter.getCity() + ", " + MainActivity.sitter.getState() + ", " + Integer.valueOf(MainActivity.sitter.getZip());
        cityStateZipTV.setText(cityStateZip);
    }

    /**
    * method to go back to previous view
     */
    public void goBack(View view) {
        finish();
    }


    /**
     * TO DO!!
     */
    public void editProfile(View view)
    {
        editText.setEnabled(true);
        editText.requestFocus();
        editAdd.setEnabled(true);
        editAdd.requestFocus();
        editZip.setEnabled(true);
        editZip.requestFocus();

        b.setVisibility(View.VISIBLE);

    }
    public void save(View view)
    {
        //MainActivity.sitter.setFirst(editText.toString());
        //MainActivity.sitter.setLast(editText.toString());
        editText.setEnabled(false);

        //MainActivity.sitter.setAddress(editAdd.toString());
        editAdd.setEnabled(false);

       // MainActivity.sitter.setCity(editZip.toString());
        editZip.setEnabled(false);
        //handle name change
        String name = editText.getText().toString();
        String[] names = name.split(" ");
        boolean validInput = true;

        if(names.length == 3)
        {
            MainActivity.sitter.setFirst(names[1]);
            MainActivity.sitter.setLast(names[2]);
        }
        else{
            Log.w("MA", "first: " + names[1] + " last: "+ names[2]);
            Log.w("MA", "loc len: "+ names.length);
            editText.setText("Invalid Input will not be saved: Format = Name: [first] [last]");
            validInput = false;
        }
        //handle address change
        String[] address = editAdd.getText().toString().split(":");
        if(address.length == 2 && address[0].equals("Address")){
            MainActivity.sitter.setAddress(address[1].substring(1));
        }
        else{
            editAdd.setText("Invalid Input will not be saved: Format = Address: [street address]");
            validInput = false;
        }

        //handle location change
        String[] location = editZip.getText().toString().split(",");
        if(location.length == 3) { // && location[1].length() == 3 && location[0].charAt(location[0].length()) == ',' && location[1].charAt(location[1].length()) == ',' ){
             try{
                 MainActivity.sitter.setZip(Integer.parseInt(location[2].replaceAll("\\s", "")));
                 Log.w("MA", "zip: " + location[2].replaceAll("\\s", ""));
             }catch (NumberFormatException nfe) {
                 Log.w("MA", "zip: " + location[2].replaceAll("\\s", ""));
                 editZip.setText("Invalid Input will not be saved: Format = [city], [state (2 letters)], [zip code(int)]");
                 validInput = false;
             }
             MainActivity.sitter.setState(location[1].replaceAll("\\s", ""));
             MainActivity.sitter.setCity(location[0].replaceAll("\\s", ""));
        }
        else {
            Log.w("MA", "loc len: "+ location.length);
            Log.w("MA", "loc len: "+ location.length);
            validInput = false;
            editZip.setText("Invalid Input will not be saved: Format = [city], [state (2 letters)], [zip code]");
        }
        b.setVisibility(View.INVISIBLE);

        if(validInput == true){
            //update info in database
            ThreadTaskUpdateSitter updateSitter = new ThreadTaskUpdateSitter(this);
            updateSitter.start();
        }

    }

}
