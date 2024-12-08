package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.LocalRecommendationServiceClient;
import com.tpk.trip_advisor.dto.LocalRecommendations;
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
