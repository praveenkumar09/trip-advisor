package com.tpk.trip_advisor.serviceImpl;

import com.tpk.trip_advisor.dto.Flight;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.service.FlightReservationServiceClient;
import com.tpk.trip_advisor.service.FlightSearchServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

import java.util.List;


@RequiredArgsConstructor
public class FlightReservationServiceImpl implements FlightReservationServiceClient {

    private final RestClient restClient;


    @Override
    public FlightReservationResponse getFlightReservation(FlightReservationRequest flightReservationRequest) {
        return this.restClient.post()
                .body(flightReservationRequest)
                .retrieve()
                .body(FlightReservationResponse.class);
    }
}
