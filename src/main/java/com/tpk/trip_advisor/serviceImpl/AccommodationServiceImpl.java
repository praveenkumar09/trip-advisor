package com.tpk.trip_advisor.serviceImpl;

import com.tpk.trip_advisor.dto.Accommodation;
import com.tpk.trip_advisor.service.AccommodationServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationServiceClient {

    private final RestClient restClient;

    @Override
    public List<Accommodation> getAccommodations(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}",airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
