package com.tpk.trip_advisor.controller;


import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.dto.TripPlan;
import com.tpk.trip_advisor.dto.TripReservationRequest;
import com.tpk.trip_advisor.service.TripPlanService;
import com.tpk.trip_advisor.service.TripReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trip")
@RequiredArgsConstructor
public class TripController {

    private final TripPlanService tripPlanService;
    private final TripReservationService tripReservationService;

    @GetMapping("{airportCode}")
    public TripPlan planTrip(@PathVariable String airportCode){
        return this.tripPlanService.getTripPlan(airportCode);
    }

    @PostMapping("reserve")
    public FlightReservationResponse reserveFlight(@RequestBody TripReservationRequest request){
        return this.tripReservationService.bookFlight(request);
    }
}
