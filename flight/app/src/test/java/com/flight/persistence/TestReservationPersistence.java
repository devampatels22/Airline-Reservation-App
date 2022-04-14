package com.flight.persistence;

import com.flight.application.Services;
import com.flight.objects.Flight;
import com.flight.objects.Reservation;

import org.junit.Test;

public class TestReservationPersistence {
    //This test is for tdd and wont run with real implementation and only under specific controls
    //aka for Jordon's tdd only


    @Test
    public void insertAndRetrieve(){
        IHsqldbReservations x = Services.getReservationPersistence();
        Reservation y = new Reservation("jordon@hotmail.com","Winnipeg","Calgary",400.15,"05/04/22");
        Reservation[] z;
        x.insert(y);
        z = x.search("jordon@hotmail.com");
        assert((z[0].getDeparture()).equals("Winnipeg") && (z[0].getArrival()).equals("Calgary") && z[0].getPrice() == 400.15
            && (z[0].getDate()).equals("05/04/22"));
    }

    @Test
    public void grabMultiple(){
        IHsqldbReservations x = Services.getReservationPersistence();
        Reservation y = new Reservation("jordon@hotmail.com","Winnipeg","Edmonton",400.15,"05/04/22");
        Reservation z = new Reservation("jordon@hotmail.com","Toronto","Vancouver",800.15,"05/04/22");
        Reservation[] a;
        x.insert(y);
        x.insert(z);
        a = x.search("jordon@hotmail.com");
        System.out.println(a.length);
        assert((a[1].getDeparture()).equals("Winnipeg") && (a[1].getArrival()).equals("Edmonton") && a[1].getPrice() == 400.15
                && (a[1].getDate()).equals("05/04/22"));
        assert((a[2].getDeparture()).equals("Toronto") && (a[2].getArrival()).equals("Vancouver") && a[2].getPrice() == 800.15
                && (a[2].getDate()).equals("05/04/22"));
    }

}
