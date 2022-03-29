package com.flight.business;

import com.flight.application.Services;
import com.flight.persistence.Flight;
import com.flight.persistence.IHsqldbFlights;

import org.junit.Test;

public class TestFlightSearch {
    @Test
    public void searchFlight(){
        IHsqldbFlights flightPersist = Services.getFlightPersistence();
        Flight x = flightPersist.search("YWG","YUL");
        assert(x.getDepartureCityCode().equals("YWG") && x.getArrivalCityCode().equals("YUL") && x.getDistance() == 1818);
        x = flightPersist.search("YVR","YYZ");
        assert(x.getDepartureCityCode().equals("YVR") && x.getArrivalCityCode().equals("YYZ") && x.getDistance() == 3345);
    }

    @Test
    public void returnNull(){
        IHsqldbFlights flightPersist = Services.getFlightPersistence();
        Flight x = null;
        x = flightPersist.search("NOT","HERE");
        assert(x == null);
    }
}
