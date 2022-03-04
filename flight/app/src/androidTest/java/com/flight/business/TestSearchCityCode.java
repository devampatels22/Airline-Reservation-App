package com.flight.business;

import org.junit.Test;

import static org.junit.Assert.*;

import com.flight.persistence.CityCode;
import com.flight.persistence.CityCodesArray;


public class TestSearchCityCode {
    @Test
    public void TestAccessDB() {
        CityCodesArray fakeDB = new CityCodesArray();
        assertNotNull(fakeDB);
    }

    // test if return correct boolean and test if can ignore user query case
    @Test
    public void Test_isFind_normalCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("Calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity_Bool("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("calgary");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity_Bool("yyc");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("CALGARY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity_Bool("YYC");
        assertTrue(result2);
    }
    @Test
    public void Test_isFind_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("CalGArY");
        assertTrue(result1);
        boolean result2 = searchLogic.isFindCity_Bool("YyC");
        assertTrue(result2);
    }
    @Test
    public void Test_notFind_normalCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("Calgar");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity_Bool("YY");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("calgry");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity_Bool("yc");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("CAGARY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity_Bool("YC");
        assertFalse(result2);
    }
    @Test
    public void Test_notFind_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        boolean result1 = searchLogic.isFindCity_Bool("ClGAY");
        assertFalse(result1);
        boolean result2 = searchLogic.isFindCity_Bool("yC");
        assertFalse(result2);
    }

    // test if return correct city object and if can ignore user query case
    @Test
    public void Test_get_findCity_obj() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query1 = "Winnipeg";
        CityCode result1 = searchLogic.get_findCity_obj(query1);
        assertEquals(result1.getName(), query1);
        String query2 = "YWG";
        CityCode result2 = searchLogic.get_findCity_obj(query2);
        assertEquals(result2.getCode(), query2);
    }
    @Test
    public void Test_get_findCity_objName_lowerCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query1 = "winnipeg";
        CityCode result1 = searchLogic.get_findCity_obj(query1);
        assertNotNull(result1);
        String query2 = "ywg";
        CityCode result2 = searchLogic.get_findCity_obj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_get_findCity_objName_upperCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query = "WINNIPEG";
        CityCode result = searchLogic.get_findCity_obj(query);
        assertNotNull(result);
        String query2 = "YWG";
        CityCode result2 = searchLogic.get_findCity_obj(query2);
        assertNotNull(result2);
    }
    @Test
    public void Test_get_findCity_objName_casualCase() {
        AccessCityCode searchLogic = new AccessCityCode();
        String query = "WinNIpEG";
        CityCode result = searchLogic.get_findCity_obj(query);
        assertNotNull(result);
        String query2 = "Ywg";
        CityCode result2 = searchLogic.get_findCity_obj(query2);
        assertNotNull(result2);
    }

    // test entire return array
    @Test
    public void Test_get_allCity_ObjArr() {
        CityCodesArray fakeDB = new CityCodesArray();
        CityCode[] originalArray = fakeDB.getArray();
        AccessCityCode searchLogic = new AccessCityCode();
        CityCode[] testArray = searchLogic.get_allCity_ObjArr();
        // 1. test two arrays whether have same length
        assertEquals(originalArray.length, testArray.length);
        // 2. test each item in array among two arrays
        for (int i = 0; i < originalArray.length; i++) {
            assertEquals(originalArray[i].getName(), testArray[i].getName());
            assertEquals(originalArray[i].getCode(), testArray[i].getCode());
        }
    }
    @Test
    public void Test_get_allCity_strArr() {
        CityCodesArray fakeDB = new CityCodesArray();
        CityCode[] OriginalArray = fakeDB.getArray();
        AccessCityCode searchLogic = new AccessCityCode();
        String[] testArray = searchLogic.get_allCity_StrArr();
        // 1. test two arrays whether have same length
        assertEquals(OriginalArray.length, testArray.length);
        // 2. test each item in array among two arrays
        String temp = "";
        for (int i = 0; i < OriginalArray.length; i++) {
            temp = OriginalArray[i].getName() + " " + OriginalArray[i].getCode();
            assertEquals(temp, testArray[i]);
        }
    }
}
