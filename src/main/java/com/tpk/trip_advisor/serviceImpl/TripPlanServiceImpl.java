package com.tpk.trip_advisor.serviceImpl;


import com.tpk.trip_advisor.client.*;
import com.tpk.trip_advisor.dto.*;
import com.tpk.trip_advisor.service.TripPlanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@RequiredArgsConstructor
public class TripPlanServiceImpl implements TripPlanService {

    private static final Logger log = LoggerFactory.getLogger(TripPlanServiceImpl.class);
    private final AccommodationServiceClient accommodationServiceClient;
    private final EventServiceClient eventServiceClient;
    private final WeatherServiceClient weatherServiceClient;
    private final TransportationServiceClient transportationServiceClient;
    private final LocalRecommendationServiceClient localRecommendationServiceClient;
    private final ExecutorService executorService;


    @Override
    public TripPlan getTripPlan(String airportCode) {
        Future<List<Event>> eventFutureList = this.executorService.submit(() -> this.eventServiceClient.getEvents(airportCode));
        Future<List<Accommodation>> accommodationFutureList = this.executorService.submit(() -> this.accommodationServiceClient.getAccommodations(airportCode));
        Future<Weather> weatherFutureList = this.executorService.submit(() -> this.weatherServiceClient.getWeather(airportCode));
        Future<Transportation> transportationFutureList = this.executorService.submit(() -> this.transportationServiceClient.getTransportation(airportCode));
        Future<LocalRecommendations> localRecommendationFutureList = this.executorService.submit(() -> this.localRecommendationServiceClient.getLocalRecommendations(airportCode));

        return new TripPlan(airportCode,
                getOrElse(accommodationFutureList, Collections.emptyList()),
                getOrElse(weatherFutureList,null),
                getOrElse(eventFutureList,Collections.emptyList()),
                getOrElse(localRecommendationFutureList,null),
                getOrElse(transportationFutureList,null));
    }

    private <T> T getOrElse(Future<T> future, T defaultValue) {
        try {
            return future.get();
        } catch (Exception e) {
            log.error("Error in trip Plan Service : {}",e.getMessage());
        }
        return defaultValue;
    }
}
