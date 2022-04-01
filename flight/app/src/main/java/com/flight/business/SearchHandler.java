package com.flight.business;
import com.flight.application.Services;
import com.flight.objects.Flight;
import com.flight.persistence.IHsqldbFlights;

public class SearchHandler {
    private String arrivalCity;
    private String departureCity;
    private String date;
    private FlightTable table;
    public SearchHandler(String[] departure, String[] arrival, String d){

        try{
            departureCity = departure[1];
            arrivalCity = arrival[1];
            date = d;
        } catch (Exception e){
            System.out.println("Possibly nothing in str[1] for departure or arrival city:" +e);
        }

    }

    //***************Added to account for only the departure and city code *************************
    public SearchHandler(String departure, String arrival, String d){
        try{
            departureCity = departure;
            arrivalCity = arrival;
            date = d;
        } catch (Exception e){
            System.out.println("Possibly nothing in str[1] for departure or arrival city:" +e);
        }
    }
    //**********************************************************************************************

    //PLease ignore for test purpose only.
//    public static void main(String[] args){
//        SearchHandler ss = new SearchHandler(new String[]{"Winnipeg", "YWG"}, new String[]{"Calgary","YYC"} ,"jan30");
//
//        //ss.populateFakeDB();
//
//        FlightTable flt = ss.handleFakeDB();
//        System.out.println("FLIGHT TABLE: "+ ss.getDate()+"\n" + flt );
//    }


    private void populateFakeDB(){
        IHsqldbFlights fh = Services.getFlightHandler();
        Flight f = fh.search(departureCity,arrivalCity);
        FlightsInfo fi = new FlightsInfo(f);
        table = new FlightTable(fi);
    }

    private void populateRealDB(){
        IHsqldbFlights fh = Services.getFlightPersistence();
        Flight x = fh.search(departureCity,arrivalCity);
        FlightsInfo ii = new FlightsInfo(x);
        table = new FlightTable(ii);

    }

    public String getDate(){
        return date;
    }

    public FlightTable handleRealDB(){
        table = null;
        populateRealDB();
        return table;
    }

    public FlightTable handleFakeDB(){
        table = null;
        populateFakeDB();
        return table;
    }
}
