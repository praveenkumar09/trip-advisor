package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.TripPlan;

public interface TripPlanService {
    public TripPlan getTripPlan(String airportCode);
}
