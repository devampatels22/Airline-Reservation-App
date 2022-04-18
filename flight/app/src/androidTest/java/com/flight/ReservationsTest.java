package com.flight;

import android.util.Log;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.flight.application.Services;
import com.flight.objects.Reservation;
import com.flight.persistence.IHsqldbReservations;
import com.flight.presentation.MainActivity;

import org.junit.Rule;
import org.junit.Test;

public class ReservationsTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);


    //not finished complete testing yet
    @Test
    public void insertAndRetrieve(){
        IHsqldbReservations x = Services.getReservationPersistence();
        Reservation y = new Reservation("jordon@hotmail.com","05/04/22","5:00","Winnipeg","6:00","Calgary","400.15");
        Reservation[] z;
        x.insert(y);
        z = x.search("jordon@hotmail.com");
        Log.d("DATE", z[0].getDate());
        assert((z[0].getDate()).equals("05/04/22"));
    }

}
