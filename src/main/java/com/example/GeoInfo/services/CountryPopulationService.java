package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.CityPopulationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CountryPopulationService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    public CityPopulationResponse getCountryPopulation() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://countriesnow.space/api/v0.1/countries/capital"))
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
