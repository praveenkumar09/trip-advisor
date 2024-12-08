package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.FlightReservationServiceClient;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;


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
