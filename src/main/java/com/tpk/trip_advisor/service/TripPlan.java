package com.tpk.trip_advisor.service;

import java.util.List;

public record TripPlan(String airportCode,
                       List<Accommodation> accommodations,
                       Weather weather,
                       List<Event> events,
                       LocalRecommendations localRecommendations,
                       Transportation transportation) {
}