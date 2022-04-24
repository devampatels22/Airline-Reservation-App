package com.flight.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.flight.persistence.IHsqldbReservations;
import com.flight.persistence.hsqldb.ReservationPersistenceHSQLDB;
import com.flight.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AccessReservationIT {
    private ResSearchHandler resSearchHandler;
    private File tempDB;
    private ResInfo resInfo;
    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final IHsqldbReservations persistence = new ReservationPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.resSearchHandler = new ResSearchHandler(persistence, "abc@gmail.com");
        resInfo = new ResInfo("abc@gmail.com", "jan30", "jan31", "ABC","feb01", "DEF", "100", persistence);
    }

    @Test
    public void testSearchReservations() {

        resInfo.addResInfo();

        ArrayList<ResInfo> table = resSearchHandler.getResTable();

        assertFalse(table.isEmpty());
        assertEquals(1, table.size());

        System.out.println("Finished test AccessCourses");
    }
    @After
    public void tearDown() {
        // reset DB
        this.tempDB.delete();
    }
}
