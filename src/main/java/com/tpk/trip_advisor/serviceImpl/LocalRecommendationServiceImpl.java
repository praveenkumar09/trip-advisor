package com.tpk.trip_advisor.serviceImpl;

import com.tpk.trip_advisor.dto.LocalRecommendations;
import com.tpk.trip_advisor.service.LocalRecommendationServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;


@RequiredArgsConstructor
public class LocalRecommendationServiceImpl implements LocalRecommendationServiceClient {

    private final RestClient restClient;

    @Override
    public LocalRecommendations getLocalRecommendations(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}",airportCode)
                .retrieve()
                .body(LocalRecommendations.class);
    }
}
