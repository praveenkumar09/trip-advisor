package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.FlightSearchServiceClient;
import com.tpk.trip_advisor.dto.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class FlightSearchServiceClientImpl implements FlightSearchServiceClient {

    private final RestClient client;

    public List<Flight> getFlights(String departure, String arrival){
        return this.client.get()
                .uri("/{departure}/{arrival}", departure, arrival)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Flight>>() {
                });
    }

}
