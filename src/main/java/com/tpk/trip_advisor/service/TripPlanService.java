package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.TripPlan;import org.springframework.stereotype.Service;

@Service
public interface TripPlanService {

    public TripPlan getTripPlan(String airportCode);
}
