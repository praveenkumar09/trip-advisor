package com.tpk.trip_advisor.service;

import com.tpk.trip_advisor.dto.Weather;

public interface WeatherServiceClient {

    public Weather getWeather(String airportCode);
}
