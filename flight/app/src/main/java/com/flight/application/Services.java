package com.flight.application;

import com.flight.persistence.CityCodesArray;
import com.flight.persistence.FakeDB;
import com.flight.persistence.FlightHandler;
import com.flight.persistence.IHsqldbFlights;
import com.flight.persistence.IHsqldbReservations;
import com.flight.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.flight.persistence.hsqldb.ReservationPersistenceHSQLDB;

public class Services {
    private static IHsqldbReservations rp = null;
    private static IHsqldbFlights fp = null;
    private static FlightHandler fh = null;
    private static FakeDB fakeDBPersistence = null;

    public static synchronized FlightHandler getFlightHandler(){
        if (fh == null)
        {
            fh = new FlightHandler();
        }
        return fh;
    }

    public static synchronized IHsqldbFlights getFlightPersistence()
    {
        if (fp == null)
        {
            fp = new FlightPersistenceHSQLDB(Main.getDBPathName());
        }

        return fp;
    }

    public static synchronized IHsqldbReservations getReservationPersistence()
    {
        if (rp == null)
        {
            rp = new ReservationPersistenceHSQLDB(Main.getDBPathName());
        }

        return rp;
    }

    public static synchronized FakeDB getFakeDBPersistence()
    {
        if (fakeDBPersistence == null)
        {
            fakeDBPersistence = new CityCodesArray();
        }

        return fakeDBPersistence;
    }
}
