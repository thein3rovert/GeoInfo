package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.CityPopulationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.GeoInfo.constant.Constants.CITIES_API_URL;

@Service
public class CountryPopulationService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    public CityPopulationResponse getCountryPopulation() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(CITIES_API_URL))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return new ObjectMapper().readValue(response.body(), CityPopulationResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
