package com.flight.business;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import org.junit.BeforeClass;
import org.junit.Test;

public class TestSearchHandler {
    private SearchHandler ss;


    public void setUp(String[] dep, String[] arr, String date) {
        ss = new SearchHandler(dep,arr,date);
    }

    @BeforeClass
    public static void Test_starts() {
        System.out.println("Starting test TestSearchHandler\n");
    }

    @Test
    public void Test_flightTableEmpty(){
        setUp(new String[]{"Winnipeg", "YWG"}, new String[]{"Calgary","YYC"} ,"jan30");
        assertFalse(ss.handleFakeDB().getFlightTable().isEmpty());
    }

    @Test
    public void Test_SearchHandlerDate(){
        setUp(new String[]{"Winnipeg", "YWG"}, new String[]{"Calgary","YYC"} ,"jan30");
        assertEquals(ss.getDate(),"jan30");
    }


}
