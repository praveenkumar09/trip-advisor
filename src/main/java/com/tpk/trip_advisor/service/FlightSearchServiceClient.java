package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.Flight;

import java.util.List;

public interface FlightSearchServiceClient {

    public List<Flight> getFlights(String departure, String arrival);
}
