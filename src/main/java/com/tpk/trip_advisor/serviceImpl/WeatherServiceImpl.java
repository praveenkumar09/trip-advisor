package com.tpk.trip_advisor.serviceImpl;

import com.tpk.trip_advisor.dto.Weather;
import com.tpk.trip_advisor.service.WeatherServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherServiceClient {

    private final RestClient restClient;


    @Override
    public Weather getWeather(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}",airportCode)
                .retrieve()
                .body(Weather.class);
    }
}
