package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.dto.TripReservationRequest;

public interface TripReservationService {
    public FlightReservationResponse reserve(TripReservationRequest request);
}
