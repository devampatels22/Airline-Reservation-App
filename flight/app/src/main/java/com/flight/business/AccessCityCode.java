package com.flight.business;

import com.flight.application.Services;
import com.flight.objects.City;
import com.flight.persistence.CityCode;
import com.flight.persistence.FakeDB;

public class AccessCityCode {
    private FakeDB fakeDB;
    private CityCode[] cityArray;
    private City city;// city obj includes CityName and CityCode

    public AccessCityCode() {
        // access fake database
        fakeDB = Services.getFakeDBPersistence();
        // get city array from database
        cityArray = fakeDB.getArray();
    }

    // this constructor is for unit testing
    public AccessCityCode(CityCode[] cityArr_testy) {
        // get city array from database
        cityArray = cityArr_testy;
    }

    // return String array
    // each item such as "Winnipeg YWG"
    public String[] getCityStrArr() {
        String[] stringArray = new String[cityArray.length];
        String toString = "";
        for (int i = 0; i < cityArray.length; i++) {
            city = new City(cityArray[i]);
            toString = city.toString();
            stringArray[i] = toString;
        }
        return stringArray;
    }

    // return Object array
    // each item such as "Winnipeg YWG"obj
    public CityCode[] getCityObjArr() {
        return cityArray;
    }

    // search user query
    // return true result if it exists in database
    public boolean isFindCity(String index) {
        boolean isFind = false;
        for (int i = 0; i < cityArray.length; i++) {
            city = new City(cityArray[i]);
            if (city.getCityName().equalsIgnoreCase(index) ||
                    city.getCityCode().equalsIgnoreCase(index)) {
                isFind = true;
            }
        }
        return isFind;
    }

    // search user query
    // return the correct result as object if it exists in database
    public CityCode getFindCityObj(String index) {
        CityCode findCity = null;
        for (int i = 0; i < cityArray.length; i++) {
            city = new City(cityArray[i]);
            if (city.getCityName().equalsIgnoreCase(index) ||
                    city.getCityCode().equalsIgnoreCase(index)) {
                findCity = city.getCityObj();
            }
        }
        return findCity;
    }

    // search user query
    // return the correct result as String if it exists in database
    public String getFindCityStr(String index) {
        String findCity = "";
        for (int i = 0; i < cityArray.length; i++) {
            city = new City(cityArray[i]);
            if (city.getCityName().equalsIgnoreCase(index) ||
                    city.getCityCode().equalsIgnoreCase(index)) {
                findCity = city.toString();
            }
        }
        return findCity;
    }

    // check user query
    // return the correct result as object if it
    public boolean isInputValid(String index) {
        boolean isValid = false;
        if (index == null) {
            isValid = false;
        } else {
            if (index.contains(" ")) {
                isValid = false;
            } else if (index.isEmpty()) {
                isValid = false;
            } else {
                isValid = true;
            }
        }
        return isValid;
    }
}

