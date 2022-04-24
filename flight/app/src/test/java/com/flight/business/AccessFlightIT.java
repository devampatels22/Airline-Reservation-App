package com.flight.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.flight.persistence.IHsqldbFlights;
import com.flight.persistence.hsqldb.FlightPersistenceHSQLDB;
import com.flight.utils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AccessFlightIT {
    private FlightTable flightTable;
    private SearchHandler ss;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final IHsqldbFlights persistence = new FlightPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        ss = new SearchHandler(new String[]{"Winnipeg", "YWG"}, new String[]{"Calgary","YYC"} ,"jan30",persistence);

    }

    @Test
    public void testSearchFlights() {

        ArrayList<FlightsInfo> table = ss.handleRealDB().getFlightTable();

        assertFalse(table.isEmpty());
        assertEquals(5, table.size());
        assertTrue("jan30".equals(ss.getDate()));

        System.out.println("Finished test AccessCourses");
    }

    //add more test

}
