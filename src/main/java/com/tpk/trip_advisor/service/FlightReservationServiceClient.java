package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;

public interface FlightReservationServiceClient {

    public FlightReservationResponse getFlightReservation(FlightReservationRequest flightReservationRequest);
}
