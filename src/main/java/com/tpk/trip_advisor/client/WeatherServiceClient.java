package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.Weather;

public interface WeatherServiceClient {
    public Weather getWeather(String airportCode);
}
