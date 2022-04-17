package com.flight.objects;

public class Reservation {
    //holds a user created Reservation

    private String email;
    private String departure;
    private String arrival;
    private String price;
    private String date;

    public Reservation(){
        //do nothing
    }

    public Reservation(String e, String depart, String a, String p, String d){
        email = e;
        departure = depart;
        arrival = a;
        price = p;
        date = d;
    }

    public String getEmail() {
        return email;
    }

    public String getDeparture(){
        return departure;
    }

    public String getArrival(){
        return arrival;
    }

    public String getPrice(){
        return price;
    }

    public String getDate(){
        return date;
    }
}
