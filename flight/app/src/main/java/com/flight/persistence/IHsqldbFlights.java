package com.flight.persistence;

interface IHsqldbFlights {
    public Flight search(String departureCityCode, String arrivalCityCode);
}

