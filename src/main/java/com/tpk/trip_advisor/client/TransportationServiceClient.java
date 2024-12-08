package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.Transportation;

public interface TransportationServiceClient {

    public Transportation getTransportation(String airportCode);
}
