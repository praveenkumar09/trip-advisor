package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;

public interface FlightReservationServiceClient {

    public FlightReservationResponse reserve(FlightReservationRequest flightReservationRequest);
}
