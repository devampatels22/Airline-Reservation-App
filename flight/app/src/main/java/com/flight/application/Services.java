package com.flight.application;

import com.flight.persistence.IHsqldbFlights;
import com.flight.persistence.hsqldb.FlightPersistenceHSQLDB;

public class Services {

    private static String dbName="flights";
    private static IHsqldbFlights fp = null;

    public static synchronized IHsqldbFlights getFlightPersistence()
    {
        if (fp == null)
        {
            fp = new FlightPersistenceHSQLDB(dbName);
        }

        return fp;
    }

    public static String getDBPathName() {
        return dbName;
    }
}
