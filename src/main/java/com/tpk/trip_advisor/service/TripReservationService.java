package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.Flight;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.dto.TripReservationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripReservationService {

    public List<Flight> getFlights(String departure, String arrival);

    public FlightReservationResponse bookFlight(TripReservationRequest request);

}
