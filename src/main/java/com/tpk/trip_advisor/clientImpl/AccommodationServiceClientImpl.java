package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.AccommodationServiceClient;
import com.tpk.trip_advisor.dto.Accommodation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class AccommodationServiceClientImpl implements AccommodationServiceClient {

    private final RestClient client;

    public List<Accommodation> getAccommodations(String airportCode) {
        return this.client.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Accommodation>>() {
                });
    }

}
