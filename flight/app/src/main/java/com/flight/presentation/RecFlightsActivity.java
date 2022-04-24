package com.flight.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.flight.R;
import com.flight.business.FlightTable;
import com.flight.business.SearchHandler;

public class RecFlightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_flights_activity);
        RecyclerView recyclerView = findViewById(R.id.flights_recycler_view_id);

        //Get the content filled on the main activity
        Intent intent = getIntent();
        String depCityString = intent.getStringExtra("departureCity");
        String arrCityString = intent.getStringExtra("arrivalCity");
        String dateString = intent.getStringExtra("travelDate");
        String depCityCode = depCityString.substring(depCityString.length()-3);
        String arrCityCode = arrCityString.substring(arrCityString.length()-3);

        //<editor-fold defaultstate="collapsed" desc="For use if passing array to search handler ">
        /*
        String[] depCityArray = depCityString.split(",");
        String[] arrCityArray = arrCityString.split(",");
         */
        // </editor-fold>

        //Set up our flight information
//        SearchHandler searchHandler = new SearchHandler("YYC", "YVR" ,"jan30");
        SearchHandler searchHandler = new SearchHandler(depCityCode, arrCityCode, dateString);

        //The grader can chose between the 2 if they want to run the actual database or fake Databse.
        //Line 43 runs fake databse that is inside flightHandler
        FlightTable flightTable = searchHandler.handleFakeDB();
        //Line 45 runs real database that is inside hsqldb folder
        //FlightTable flightTable = searchHandler.handleRealDB();

        //Set up adapter for the recycler view
        RecFlightsAdapter adapter = new RecFlightsAdapter(this, flightTable);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
