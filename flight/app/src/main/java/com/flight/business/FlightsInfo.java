package com.flight.business;


import com.flight.persistence.Flight;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class  FlightsInfo{

    private final String arrivalCityCode;
    private final String departureCityCode;
    private final int distance;
    private final Flight flight;

    //CONSTRUCTOR FlightInfo takes in Flight as constructor
    public FlightsInfo(Flight f1) {

        arrivalCityCode = f1.getArrivalCityCode();
        departureCityCode = f1.getDepartureCityCode();
        distance = f1.getDistance();
        flight = f1;

    }

    //FOR TEST PURPOSE ONLY PLEASE IGNORE
//    public static void main(String[] args){
//        Flight f = new Flight("YWG","YYC",2000);
//        FlightsInfo fi = new FlightsInfo(f);
//
//        System.out.println(Arrays.toString(fi.getDepArrTime()));
//
//    }

    //returns price of fight according to distance
    public double getPrice() {
        //check distance and based on that assign price
        double price = 0;


        Random rand = new Random();
        if (distance >= 0 && distance < 500) {
            price = 100 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 500 && distance < 1000) {
            price = 200 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 1000 && distance < 1500) {
            price = 300 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 1500 && distance < 2000) {
            price = 400 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 2000 && distance < 2500) {
            price = 500 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 2500 && distance < 3000) {
            price = 600 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 3500 && distance < 4000) {
            price = 700 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 4000 && distance < 4500) {
            price = 800 + rand.nextInt(10000) / 100.0;
        } else if (distance >= 4500 && distance < 5000) {
            price = 900 + rand.nextInt(10000) / 100.0;
        }
        return price;
    }

    //returns Time[] where
    // Time[0] -> Departure time
    // Time[1] -> Arrival time
    public Time[] getDepArrTime() {

        Time[] tt = new Time[2];
        // Assign a random time and stick with it
        Random rand = new Random();

        //creating random time within 16 hours range
        final int millisInDay = 16*60*60*1000;

        //flights normally start after 6 so adding it once random time is generated
        Time t0 = new Time((long)rand.nextInt(millisInDay) + 6*60*60*1000);
        tt[0] = t0;
        System.out.println(t0);
        Time t1 = new Time(t0.getTime() + 3600000L *(distance/500));
        tt[1] = t1;
        return tt;
    }

    //returns Departure City code
    public String getDepCity(){
        return arrivalCityCode;
    }

    //returns arrival city code
    public String getArrCity(){
        return departureCityCode;
    }

    //returns distance between cities
    public int getDistance(){
        return distance;
    }

    //returns Flight object that is passed  in flight info constructor
    public Flight getFlight(){
        return flight;
    }

    //Simple print function to print flight info properly.
    public String toString(){
        return getDepCity() +" "+ getArrCity() +"| DEP time "+ getDepArrTime()[0] +"| ARR time "+ getDepArrTime()[1] +"| Price:"+ getPrice() + "||" ;
    }
}