package com.tpk.trip_advisor.service;

import java.time.LocalDate;

public record Flight(String flightNumber,
                     String airline,
                     int price,
                     LocalDate date,
                     int flightDurationInMinutes) {
}
