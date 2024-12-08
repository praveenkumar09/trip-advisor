package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.EventServiceClient;
import com.tpk.trip_advisor.dto.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;


@RequiredArgsConstructor
public class EventServiceImpl implements EventServiceClient {


    private final RestClient restClient;

    @Override
    public List<Event> getEvents(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}",airportCode)
                .retrieve()
                .body(new ParameterizedTypeReference<List<Event>>(){});
    }
}
