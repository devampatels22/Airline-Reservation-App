package com.flight.business;
import com.flight.persistence.Flight;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFlightInfo {
    private Flight f;
    private FlightsInfo fi;

    public void setUp(String departureCityCode, String arrivalCityCode, int distance) {
        f = new Flight(departureCityCode, arrivalCityCode, distance);
        fi = new FlightsInfo(f);
    }

    @BeforeClass
    public static void Test_starts() {
        System.out.println("Starting test TestFlightInfo\n");
    }

    @Test
    public void Test_getDistance() {
        setUp("tempDcc", "tempAcc", 300);
        assertEquals(fi.getDistance(), f.getDistance());
    }

    @Test
    public void Test_priceReturn_distance300() {
        setUp("tempDcc", "tempAcc", 300);
        assertTrue(fi.getPrice() >= 100 && fi.getPrice() <= 200);
    }
    @Test
    public void Test_priceReturn_distance800() {
        setUp("tempDcc", "tempAcc", 800);
        assertTrue(fi.getPrice() >= 200 && fi.getPrice() <= 300);
    }
    @Test
    public void Test_priceReturn_distance1300() {
        setUp("tempDcc", "tempAcc", 1300);
        assertTrue(fi.getPrice() >= 300 && fi.getPrice() <= 400);
    }
    @Test
    public void Test_priceReturn_distance1800() {
        setUp("tempDcc", "tempAcc", 1800);
        assertTrue(fi.getPrice() >= 400 && fi.getPrice() <= 500);
    }
    @Test
    public void Test_priceReturn_distance2300() {
        setUp("tempDcc", "tempAcc", 2300);
        assertTrue(fi.getPrice() >= 500 && fi.getPrice() <= 600);
    }
    @Test
    public void Test_priceReturn_distance2800() {
        setUp("tempDcc", "tempAcc", 2800);
        assertTrue(fi.getPrice() >= 600 && fi.getPrice() <= 700);
    }
    @Test
    public void Test_priceReturn_distance3300() {
        setUp("tempDcc", "tempAcc", 3300);
        assertTrue(fi.getPrice() >= 700 && fi.getPrice() <= 800);
    }
    @Test
    public void Test_priceReturn_distance3800() {
        setUp("tempDcc", "tempAcc", 3800);
        assertTrue(fi.getPrice() >= 800 && fi.getPrice() <= 900);
    }
    @Test
    public void Test_priceReturn_distance4300() {
        setUp("tempDcc", "tempAcc", 4300);
        assertTrue(fi.getPrice() >= 900 && fi.getPrice() <= 1000);
    }
    @Test
    public void Test_priceReturn_distance4800() {
        setUp("tempDcc", "tempAcc", 4800);
        assertTrue(fi.getPrice() >= 1000 && fi.getPrice() <= 1100);
    }

    @Test
    public void Test_getDepCity() {
        setUp("YYC", "WPG", 300);
        assertEquals(fi.getDepCity(), f.getDepartureCityCode());
    }
    @Test
    public void Test_getArrCity() {
        setUp("YYZ", "YVR", 1800);
        assertEquals(fi.getArrCity(), f.getArrivalCityCode());
    }

    @Test
    public void Test_getFlight() {
        setUp("YYC", "WPG", 3200);
        assertEquals("YYC", fi.getFlight().getDepartureCityCode());
        assertEquals("WPG", fi.getFlight().getArrivalCityCode());
        assertEquals(3200, fi.getFlight().getDistance());
    }

    @AfterClass
    public static void Test_finish() {
        System.out.println("Finished test TestFlightInfo\n");
    }
}
