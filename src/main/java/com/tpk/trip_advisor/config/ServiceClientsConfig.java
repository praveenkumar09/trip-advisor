package com.tpk.trip_advisor.config;

import com.tpk.trip_advisor.client.*;
import com.tpk.trip_advisor.clientImpl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.util.concurrent.Executors;

@Configuration
public class ServiceClientsConfig {

    private static final Logger log = LoggerFactory.getLogger(ServiceClientsConfig.class);

    @Value("${spring.threads.virtual.enabled}")
    private boolean isVirtualThreadEnabled;

    @Bean
    public AccommodationServiceClient accommodationServiceClient(@Value("${accommodation.service.url}") String baseUrl){
        return new AccommodationServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public EventServiceClient eventServiceClient(@Value("${event.service.url}") String baseUrl){
        return new EventServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public WeatherServiceClient weatherServiceClient(@Value("${weather.service.url}") String baseUrl){
        return new WeatherServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public TransportationServiceClient transportationServiceClient(@Value("${transportation.service.url}") String baseUrl){
        return new TransportationServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public LocalRecommendationServiceClient recommendationServiceClient(@Value("${local-recommendation.service.url}") String baseUrl){
        return new LocalRecommendationServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public FlightSearchServiceClient flightSearchServiceClient(@Value("${flight-search.service.url}") String baseUrl){
        return new FlightSearchServiceClientImpl(buildRestClient(baseUrl));
    }

    @Bean
    public FlightReservationServiceClient reservationServiceClient(@Value("${flight-reservation.service.url}") String baseUrl){
        return new FlightReservationServiceClientImpl(buildRestClient(baseUrl));
    }

    private RestClient buildRestClient(String baseUrl){
        log.info("base url: {}", baseUrl);
        RestClient.Builder builder = RestClient.builder()
                .baseUrl(baseUrl);
        if(isVirtualThreadEnabled) {
            builder.requestFactory(new JdkClientHttpRequestFactory(HttpClient.newBuilder().executor(Executors.newVirtualThreadPerTaskExecutor()).build()))
                    .build();
        }
        return builder.build();
    }
}
