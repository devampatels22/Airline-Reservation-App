package com.flight.persistence;

public interface FakeDB {
    public CityCode search(String name);
    public void print();
}