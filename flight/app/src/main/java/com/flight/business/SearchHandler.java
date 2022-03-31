package com.flight.business;
import com.flight.persistence.FlightHandler;
import com.flight.persistence.Flight;
import com.flight.business.FlightsInfo;

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

//    public static void main(String[] args){
//        SearchHandler ss = new SearchHandler(new String[]{"Winnipeg", "YWG"}, new String[]{"Calgary","YYC"} ,"jan30");
//        FlightHandler fh = new FlightHandler();
//        Flight f = fh.search(ss.departureCity,ss.arrivalCity);
//        FlightsInfo fi = new FlightsInfo(f);
//        FlightTable flt = new FlightTable(fi);
//        System.out.println("FLIGHT TABLE: "+ ss.getDate()+"\n" + flt );
//    }


    private void populate(){
        FlightHandler fh = new FlightHandler();
        Flight f = fh.search(departureCity,arrivalCity);
        FlightsInfo fi = new FlightsInfo(f);
        table = new FlightTable(fi);
    }

    public String getDate(){
        return date;
    }

    public FlightTable handle(){
        populate();
        return table;
    }
}
