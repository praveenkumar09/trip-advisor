package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.Accommodation;

import java.util.List;

public interface AccommodationServiceClient {

    public List<Accommodation> getAccommodations(String airportCode);
}
