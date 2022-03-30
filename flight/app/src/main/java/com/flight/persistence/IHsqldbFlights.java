package com.flight.persistence;

public interface IHsqldbFlights {
    public Flight search(String departureCityCode, String arrivalCityCode);
}
