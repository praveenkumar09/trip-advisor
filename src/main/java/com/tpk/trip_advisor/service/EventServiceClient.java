package com.tpk.trip_advisor.service;


import com.tpk.trip_advisor.dto.Event;

import java.util.List;

public interface EventServiceClient {

    public List<Event> getEvents(String airportCode);
}
