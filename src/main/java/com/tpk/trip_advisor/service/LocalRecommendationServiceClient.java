package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.LocalRecommendations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;


public interface LocalRecommendationServiceClient {

    public LocalRecommendations getLocalRecommendations(String airportCode);
    
}
