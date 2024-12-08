package com.tpk.trip_advisor.serviceImpl;


import com.tpk.trip_advisor.dto.Transportation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class TransportationServiceImpl {

    private final RestClient restClient;

    public Transportation getTransportation(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}",airportCode)
                .retrieve()
                .body(Transportation.class);
    }
}
