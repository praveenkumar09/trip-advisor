package com.tpk.trip_advisor.serviceImpl;

import com.tpk.trip_advisor.dto.Flight;
import com.tpk.trip_advisor.service.FlightSearchServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;


@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchServiceClient {

    private final RestClient restClient;

    @Override
    public List<Flight> getFlights(String departure, String arrival) {
        return this.restClient.get()
                .uri("/{departure}/{arrival}",departure,arrival)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
