package com.flight;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.flight.business.TestFlightInfo;
import com.flight.business.TestFlightTable;
import com.flight.business.TestSearchCityCode;
import com.flight.business.TestSearchHandler;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestFlightInfo.class,
        // note: only run with hsqldb running on pc
        // refer to README_HOWTORUN.txt in the main directory
        //TestFlightSearch.class,
        TestFlightTable.class,
        TestSearchCityCode.class,
        TestSearchHandler.class
})

public class AllUnitTests {
}
