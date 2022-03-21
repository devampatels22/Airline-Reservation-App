package com.flight.application;

import com.flight.persistence.CityCodesArray;
import com.flight.persistence.FakeDB;

public class Services {
    private static FakeDB fakeDBPersistence = null;

    public static synchronized FakeDB getFakeDBPersistence()
    {
        if (fakeDBPersistence == null)
        {
            fakeDBPersistence = new CityCodesArray();
        }

        return fakeDBPersistence;
    }
}
