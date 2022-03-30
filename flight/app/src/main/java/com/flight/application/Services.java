package com.flight.application;

import com.flight.persistence.CityCodesArray;
import com.flight.persistence.FakeDB;
import com.flight.persistence.IHsqldbFlights;
import com.flight.persistence.hsqldb.FlightPersistenceHSQLDB;

public class Services {

    private static String dbName="flights";
    private static IHsqldbFlights fp = null;
    private static FakeDB fakeDBPersistence = null;

    public static synchronized IHsqldbFlights getFlightPersistence()
    {
        if (fp == null)
        {
            fp = new FlightPersistenceHSQLDB(dbName);
        }

        return fp;
    }

    public static synchronized FakeDB getFakeDBPersistence()
    {
        if (fakeDBPersistence == null)
        {
            fakeDBPersistence = new CityCodesArray();
        }

        return fakeDBPersistence;
    }

    public static String getDBPathName() {
        return dbName;
    }
}
