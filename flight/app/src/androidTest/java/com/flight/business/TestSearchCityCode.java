package com.flight.business;

import org.junit.Test;

import static org.junit.Assert.*;

import com.flight.application.Services;
import com.flight.objects.City;
import com.flight.persistence.CityCode;
import com.flight.persistence.FakeDB;


public class TestSearchCityCode {
    @Test
    public void Test_accessDB() {
        FakeDB fakeDB = Services.getFakeDBPersistence();
        assertNotNull(fakeDB);
    }

    // test if return correct boolean and test if can ignore user query case
    @Test
    public void Test_isFind_normalCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("Calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("yyc");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("CALGARY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("CalGArY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity("YyC");
        assertTrue(result2);
    }
    @Test
    public void Test_notFind_normalCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("Calgar");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("YY");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("calgry");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("yc");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("CAGARY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("YC");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity("ClGAY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity("yC");
        assertFalse(result2);
    }

    // test if return correct city object and if can ignore user query case
    @Test
    public void Test_getFindCityObj() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query1 = "Winnipeg";
        CityCode result1 = searchLogic.getFindCityObj(query1);
        assertEquals(result1.getName(), query1);
        String query2 = "YWG";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertEquals(result2.getCode(), query2);
    }
    @Test
    public void Test_getFindCityName_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query1 = "winnipeg";
        CityCode result1 = searchLogic.getFindCityObj(query1);
        assertNotNull(result1);
        String query2 = "ywg";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_getFindCityName_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query = "WINNIPEG";
        CityCode result = searchLogic.getFindCityObj(query);
        assertNotNull(result);
        String query2 = "YWG";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_getFindCityName_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query = "WinNIpEG";
        CityCode result = searchLogic.getFindCityObj(query);
        assertNotNull(result);
        String query2 = "Ywg";
        CityCode result2 = searchLogic.getFindCityObj(query2);
        assertNotNull(result2);
    }

    // test entire return array
    @Test
    public void Test_getCityObjArr() {
        FakeDB fakeDB = Services.getFakeDBPersistence();
        AccessCityCode searchLogic = new AccessCityCode();
        CityCode[] testArray = searchLogic.getCityObjArr();
        // 1. test two arrays whether have same length
        assertEquals(fakeDB.getArray().length, testArray.length);
        // 2. test each item in array among two arrays
        for (int i = 0; i < fakeDB.getArray().length; i++) {
            City city = new City((fakeDB.getArray())[i]);
            assertEquals(city.getCityName(), testArray[i].getName());
            assertEquals(city.getCityCode(), testArray[i].getCode());
        }
    }
    @Test
    public void Test_getCityStrArr() {
        FakeDB fakeDB = Services.getFakeDBPersistence();
        AccessCityCode searchLogic = new AccessCityCode();
        String[] testArray = searchLogic.getCityStrArr();
        // 1. test two arrays whether have same length
        assertEquals(fakeDB.getArray().length, testArray.length);
        // 2. test each item in array among two arrays
        String temp = "";
        for (int i = 0; i < fakeDB.getArray().length; i++) {
            City city = new City((fakeDB.getArray())[i]);
            assertEquals(city.toString(), testArray[i]);
        }
    }
}
