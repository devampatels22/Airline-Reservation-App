package com.flight.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.flight.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class MainActivity extends AppCompatActivity {
    //variables
    EditText select_dates, adult_num, children_num, arrival_city, departure_city;
    Switch select_trip_type;
    TextView travellersOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Enter full screen view here
        super.onCreate(savedInstanceState);
        setTheme(R.style.Base_Theme_AppCompat_Light_DarkActionBar); //CREATING A DARK THEME

        getSupportActionBar().hide(); //hiding the action bar
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //hides the status bar
        setContentView(R.layout.activity_main);

        //Default value
        adult_num = findViewById(R.id.adult_num_edit_id);
        adult_num.setText("1");

        //Calling functions for each associated traveller enters
        setDate();
        departureCity();
        arrivalCity();

    }

    //Add select Trip type here
    public void selectTripType(View view){
    }


    //Add Select date feature here
    public void setDate(){
    }

    //Add select city departure city here
    public void departureCity(){

    }

    //Add select city arrival city here
    public void arrivalCity(){

    }




    //Add search flights feature here
    public void searchFlights(View view){ //this will be called directly on the button

    }




}