package com.flight.business;


import com.flight.persistence.CityCode;
import com.flight.persistence.CityCodesArray;

public class AccessCityCode {
    private CityCodesArray fakeDB;
    private CityCode[] cityArray;

    public AccessCityCode() {
        // access fake database
        fakeDB = new CityCodesArray();
        // get city array from database
        cityArray = fakeDB.getArray();
    }

    // return String array
    // each item such as "Winnipeg YWG"
    public String[] get_allCity_StrArr() {
        String[] StringArray = new String[cityArray.length];
        String temp = "";
        for (int i = 0; i < cityArray.length; i++) {
            temp = cityArray[i].getName() + " " + cityArray[i].getCode();
            StringArray[i] = temp;
        }
        return StringArray;
    }

    // return Object array
    // each item such as "Winnipeg YWG"obj
    public CityCode[] get_allCity_ObjArr() {
        CityCode[] objArray = new CityCode[cityArray.length];
        for (int i = 0; i < cityArray.length; i++) {
            objArray[i] = cityArray[i];
        }
        return objArray;
    }

    // search user query
    // return true result if it exists in database
    public boolean isFindCity_Bool(String index) {
        boolean isFind = false;
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getName().equalsIgnoreCase(index) ||
                    cityArray[i].getCode().equalsIgnoreCase(index)) {
                isFind = true;
            }
        }
        return isFind;
    }

    // search user query
    // return the correct result if it exists in database
    public CityCode get_findCity_obj(String index) {
        CityCode findCity = null;
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getName().equalsIgnoreCase(index) ||
                    cityArray[i].getCode().equalsIgnoreCase(index)) {
                findCity = cityArray[i];
            }
        }
        return findCity;
    }

    // search user query
    // return the correct result as String if it exists in database
    public String getFindCityString(String index) {
        String findCity = "";
        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getName().equalsIgnoreCase(index) ||
                    cityArray[i].getCode().equalsIgnoreCase(index)) {
                findCity = cityArray[i].getName() + " " + cityArray[i].getCode();
            }
        }
        return findCity;
    }
}

