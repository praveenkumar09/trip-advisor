package com.tpk.trip_advisor.service;

import java.time.LocalDate;
import java.util.UUID;

public record FlightReservationResponse(UUID reservationId,
                                        String departure,
                                        String arrival,
                                        String flightNumber,
                                        LocalDate tripDate,
                                        int price) {
}
