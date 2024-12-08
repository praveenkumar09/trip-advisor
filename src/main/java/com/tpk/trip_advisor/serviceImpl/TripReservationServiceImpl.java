package com.tpk.trip_advisor.serviceImpl;


import com.tpk.trip_advisor.client.FlightReservationServiceClient;
import com.tpk.trip_advisor.client.FlightSearchServiceClient;
import com.tpk.trip_advisor.dto.Flight;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.dto.TripReservationRequest;
import com.tpk.trip_advisor.service.TripReservationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripReservationServiceImpl implements TripReservationService {

    private static final Logger logger = LoggerFactory.getLogger(TripReservationService.class);

    private FlightReservationServiceClient flightReservationServiceClient;
    private FlightSearchServiceClient flightSearchServiceClient;

    @Override
    public List<Flight> getFlights(String departure, String arrival) {
        return flightSearchServiceClient.getFlights(departure, arrival);
    }

    @Override
    public FlightReservationResponse bookFlight(TripReservationRequest request) {
        List<Flight> flightList = this.flightSearchServiceClient.getFlights(request.departure(), request.arrival());
        Optional<Flight> optionalFlight = flightList.stream()
                .min(Comparator.comparingInt(Flight::price));
       Flight flight = optionalFlight.orElseThrow(() -> new IllegalStateException("No flight found"));
        FlightReservationRequest flightReservationRequest = new FlightReservationRequest(request.departure(), request.arrival(), flight.flightNumber(), request.date());
        return flightReservationServiceClient.reserve(flightReservationRequest);
    }
}
