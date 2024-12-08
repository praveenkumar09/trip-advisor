package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.LocalRecommendations;


public interface LocalRecommendationServiceClient {

    public LocalRecommendations getLocalRecommendations(String airportCode);
    
}
