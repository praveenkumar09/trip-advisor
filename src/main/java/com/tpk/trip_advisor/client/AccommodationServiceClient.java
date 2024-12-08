package com.tpk.trip_advisor.client;

import com.tpk.trip_advisor.dto.Accommodation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;



public interface AccommodationServiceClient {

    public List<Accommodation> getAccommodations(String airportCode);

}
