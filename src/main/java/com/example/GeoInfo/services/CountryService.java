package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.CountryRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private final CountryRequest countryRequest = new CountryRequest();

        public CountryRequest getAllCountriesAndCapital(){
            try{
            HttpRequest countriesAndCapitalRequest = HttpRequest.newBuilder()
                    .uri(URI.create(CAPITAL_API_URL))
                    .GET()
                    .build();
            HttpResponse<String> countriesAndCapitalResponse = httpClient.send(countriesAndCapitalRequest, HttpResponse.BodyHandlers.ofString());
            CountryRequest countryRequest =  objectMapper.readValue(countriesAndCapitalResponse.body(), CountryRequest.class);
            if (countryRequest.getError() == null ) {
                System.out.println("Error from API: " + countryRequest.getError());
            }

            return countryRequest;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
