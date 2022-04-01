package com.flight.business;

import com.flight.application.Services;
import com.flight.objects.Flight;
import com.flight.persistence.IHsqldbFlights;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlightSearch {
    @BeforeClass
    public static void Test_starts() {
        System.out.println("Starting test TestFlightSearch\n");
    }

    @Test
    public void searchFlight(){
        System.out.println("Starting searchFlight\n");
        IHsqldbFlights flightPersist = Services.getFlightPersistence();
        Flight x = flightPersist.search("YWG","YUL");
        assert(x.getDepartureCityCode().equals("YWG") && x.getArrivalCityCode().equals("YUL") && x.getDistance() == 1818);
        x = flightPersist.search("YVR","YYZ");
        assert(x.getDepartureCityCode().equals("YVR") && x.getArrivalCityCode().equals("YYZ") && x.getDistance() == 3345);
        System.out.println("Finished searchFlight\n");
    }

    @Test
    public void returnNull(){
        System.out.println("Starting returnNull\n");
        IHsqldbFlights flightPersist = Services.getFlightPersistence();
        Flight x = null;
        x = flightPersist.search("NOT","HERE");
        assert(x == null);
        System.out.println("Finished returnNull\n");
    }

    @AfterClass
    public static void Test_finish() {
        System.out.println("Finished test TestFlightSearch\n");
    }
}
