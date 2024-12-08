package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.FlightReservationServiceClient;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class FlightReservationServiceClientImpl implements FlightReservationServiceClient {

    private final RestClient client;

    public FlightReservationResponse reserve(FlightReservationRequest request) {
        return this.client.post()
                .body(request)
                .retrieve()
                .body(FlightReservationResponse.class);
    }

}
