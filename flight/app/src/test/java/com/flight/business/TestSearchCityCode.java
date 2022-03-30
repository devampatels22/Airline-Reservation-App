package com.flight.business;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import com.flight.application.Services;
import com.flight.objects.City;
import com.flight.persistence.CityCode;
import com.flight.persistence.FakeDB;


public class TestSearchCityCode {
    private String query;
    private AccessCityCode searchLogic;
    private CityCode[] fkDB;

    @BeforeClass
    public static void Test_starts() {
        System.out.println("Starting test TestSearchCityCode\n");
    }

    @Before
    public void setUp() {
        searchLogic = new AccessCityCode();
    }

    @Test
    public void Test_isInputInvalid_empty() {
        query = "";
        assertFalse(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_onlySpace() {
        query = " ";
        assertFalse(searchLogic.isInputValid(query));
        query = "    ";
        assertFalse(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_correct() {
        query = "Winnipeg";
        assertTrue(searchLogic.isInputValid(query));
        query = "WINNIPEG";
        assertTrue(searchLogic.isInputValid(query));
        query = "Winnipeg12233";
        assertTrue(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_spaceBetweenQuery() {
        query = "Winni peg";
        assertFalse(searchLogic.isInputValid(query));
        query = "Win nip eg";
        assertFalse(searchLogic.isInputValid(query));
        query = "Winnipe     g";
        assertFalse(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_spaceBeforeQuery() {
        query = " Winnipeg";
        assertFalse(searchLogic.isInputValid(query));
        query = "     Winnipeg";
        assertFalse(searchLogic.isInputValid(query));
        query = "  Winnip eg";
        assertFalse(searchLogic.isInputValid(query));
        query = " Winnipe     g";
        assertFalse(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_spaceAfterQuery() {
        query = "Winnipeg ";
        assertFalse(searchLogic.isInputValid(query));
        query = "Winnipeg       ";
        assertFalse(searchLogic.isInputValid(query));
        query = "Winnip eg   ";
        assertFalse(searchLogic.isInputValid(query));
        query = "Winnipe     g    ";
        assertFalse(searchLogic.isInputValid(query));
    }
    @Test
    public void Test_isInputInvalid_spaceMixedQuery() {
        query = "  Winnipeg ";
        assertFalse(searchLogic.isInputValid(query));
        query = "Winni  peg       ";
        assertFalse(searchLogic.isInputValid(query));
        query = "       Winnip eg";
        assertFalse(searchLogic.isInputValid(query));
        query = "     Winn  ipe     g    ";
        assertFalse(searchLogic.isInputValid(query));
    }

    // test if return correct boolean and test if can ignore user query case
    @Test
    public void Test_isFind_normalCase() {
        boolean result1 = searchLogic.isFindCity("Calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_lowerCase() {
        boolean result1 = searchLogic.isFindCity("calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("yyc");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_upperCase() {
        boolean result1 = searchLogic.isFindCity("CALGARY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_casualCase() {
        boolean result1 = searchLogic.isFindCity("CalGArY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YyC");
        assertTrue(result2);
    }
    @Test
    public void Test_notFind_normalCase() {
        boolean result1 = searchLogic.isFindCity("Calgar");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("YY");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_lowerCase() {
        boolean result1 = searchLogic.isFindCity("calgry");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("yc");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_upperCase() {
        boolean result1 = searchLogic.isFindCity("CAGARY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("YC");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_casualCase() {
        boolean result1 = searchLogic.isFindCity("ClGAY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("yC");
        assertFalse(result2);
    }

    // test if return correct city object and if can ignore user query case
    @Test
    public void Test_getFindCityObj() {
        String query1 = "Winnipeg";
        CityCode result1 = searchLogic.getFindCityObj(query1);
        assertEquals(result1.getName(), query1);
        String query2 = "YWG";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertEquals(result2.getCode(), query2);
    }
    @Test
    public void Test_getFindCityName_lowerCase() {
        String query1 = "winnipeg";
        CityCode result1 = searchLogic.getFindCityObj(query1);
        assertNotNull(result1);
        String query2 = "ywg";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_getFindCityName_upperCase() {
        String query = "WINNIPEG";
        CityCode result = searchLogic.getFindCityObj(query);
        assertNotNull(result);
        String query2 = "YWG";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_getFindCityName_casualCase() {
        String query = "WinNIpEG";
        CityCode result = searchLogic.getFindCityObj(query);
        assertNotNull(result);
        String query2 = "Ywg";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }

    // create a temp fake database to test
    public void create_fkDB() {
        fkDB = new CityCode[5];
        fkDB[0] = new CityCode("Calgary","YYC");
        fkDB[1] = new CityCode("Edmonton","YEG");
        fkDB[2] = new CityCode("Fredericton","YFC");
        fkDB[3] = new CityCode("Gander","YQX");
        fkDB[4] = new CityCode("Halifax","YHZ");
    }
    // test entire return array
    @Test
    public void Test_getCityObjArr() {
        create_fkDB();
        searchLogic = new AccessCityCode(fkDB);
        CityCode[] testArray = searchLogic.getCityObjArr();
        // 1. test two arrays whether have same length
        assertEquals(fkDB.length, testArray.length);
        // 2. test each item in array among two arrays
        for (int i = 0; i < fkDB.length; i++) {
            City city = new City(fkDB[i]);
            assertEquals(city.getCityName(), testArray[i].getName());
            assertEquals(city.getCityCode(), testArray[i].getCode());
        }
    }
    @Test
    public void Test_getCityStrArr() {
        create_fkDB();
        searchLogic = new AccessCityCode(fkDB);
        String[] testArray = searchLogic.getCityStrArr();
        // 1. test two arrays whether have same length
        assertEquals(fkDB.length, testArray.length);
        // 2. test each item in array among two arrays
        String temp = "";
        for (int i = 0; i < fkDB.length; i++) {
            City city = new City(fkDB[i]);
            assertEquals(city.toString(), testArray[i]);
        }
    }

    @AfterClass
    public static void Test_finish() {
        System.out.println("Finished test TestSearchCityCode\n");
    }
}
