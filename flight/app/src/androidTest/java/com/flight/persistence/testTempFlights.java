package com.flight.persistence;

import org.junit.Test;

public class testTempFlights {

    @Test
    public void testSearch(){
        IHsqldbFlights handler = new FlightHandler();
        Flight target;

        target = handler.search("YVR","YYZ");

        assert(target.getDepartureCityCode().equals("YVR") && target.getArrivalCityCode().equals("YYZ"));
    }
}
