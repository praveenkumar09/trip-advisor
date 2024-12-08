package com.tpk.trip_advisor;

import com.tpk.trip_advisor.dto.Accommodation;
import com.tpk.trip_advisor.dto.FlightReservationRequest;
import com.tpk.trip_advisor.dto.FlightReservationResponse;
import com.tpk.trip_advisor.dto.Weather;
import com.tpk.trip_advisor.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.List;

public class RestClientTests {

    private static final Logger logger = LoggerFactory.getLogger(RestClientTests.class);

    private static RestClient restClient;


    @BeforeAll
    static void setUp() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:7070/")
                .build();
    }

    @Test
    void weatherGet() {
        Weather response = restClient.get()
                .uri("sec02/weather/{airportCode}","LAS")
                .retrieve()
                .body(Weather.class);
        logger.info("Response : {}", response);
    }

    @Test
    void accommodationGet() {
        List<Accommodation> response = restClient.get()
                .uri("sec02/accommodations/{aiportCode}","LAS")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Accommodation>>() {
                });
        logger.info("Accommodations : {}", response);
    }

    @Test
    void flightReserve(){
        var req = new FlightReservationRequest("ATL","LAS","UA789", LocalDate.now());
        var response = restClient.post()
                .uri("sec03/flight/reserve")
                .body(req)
                .retrieve()
                .body(FlightReservationResponse.class);
        logger.info("Flight Reservation Response : {}", response);
    }

}
