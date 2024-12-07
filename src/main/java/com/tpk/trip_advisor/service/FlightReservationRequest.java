package com.tpk.trip_advisor.service;

import java.time.LocalDate;

public record FlightReservationRequest(String departure,
                                       String arrival,
                                       String flightNumber,
                                       LocalDate tripDate) {
}
