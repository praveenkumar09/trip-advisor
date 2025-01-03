package com.tpk.trip_advisor.clientImpl;

import com.tpk.trip_advisor.client.WeatherServiceClient;
import com.tpk.trip_advisor.dto.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public class WeatherServiceClientImpl implements WeatherServiceClient {

    private final RestClient restClient;

    public Weather getWeather(String airportCode) {
        return this.restClient.get()
                .uri("{airportCode}", airportCode)
                .retrieve()
                .body(Weather.class);
    }

}
