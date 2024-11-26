package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.CountryResponse;
import com.example.GeoInfo.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.example.GeoInfo.constant.Constants.CAPITAL_API_URL;

@Getter
@Service
public class CountryService {
    private final HttpClient httpClient = HttpClient.newBuilder().build();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final CountryResponse countryResponse = new CountryResponse();

        public CountryResponse getAllCountriesAndCapital(){
            try{
            HttpRequest countriesAndCapitalRequest = HttpRequest.newBuilder()
                    .uri(URI.create(CAPITAL_API_URL))
                    .GET()
                    .build();
            HttpResponse<String> countriesAndCapitalResponse = httpClient.send(countriesAndCapitalRequest, HttpResponse.BodyHandlers.ofString());
                // Check for non-200 HTTP status codes
                if (countriesAndCapitalResponse.statusCode() != 200) {
                    throw new ApiException(
                            "Failed to fetch countries and capitals. HTTP Status: " + countriesAndCapitalResponse.statusCode(),
                            countriesAndCapitalResponse.statusCode(),
                            countriesAndCapitalResponse.body()
                    );
                }
            CountryResponse countryResponse =  objectMapper.readValue(countriesAndCapitalResponse.body(), CountryResponse.class);
            if (countryResponse.getError() == null) {
                    throw new ApiException("API returned an error: " + countryResponse.getError());
            }
            return countryResponse;
        } catch (Exception e) {
            throw new ApiException("An error occurred while fetching countries and capitals: " + e.getMessage(), 500, e.toString());
        }
    }
}
