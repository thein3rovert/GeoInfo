package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.FlagResponse;
import com.example.GeoInfo.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static com.example.GeoInfo.constant.Constants.IMAGE_API_URL;

@Getter
@Service
public class CountryFlagService {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();



    public FlagResponse getCountryFlag (){
        try{
            HttpRequest countryFlagRequest = HttpRequest.newBuilder()
                    .uri(URI.create(IMAGE_API_URL))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            HttpResponse<String>countryFlagResponse = httpClient.send(countryFlagRequest, HttpResponse.BodyHandlers.ofString());
            if (countryFlagResponse.statusCode() != 200) {
                throw new ApiException(
                        "Failed to fetch countries and capitals. HTTP Status: " + countryFlagResponse.statusCode(),
                        countryFlagResponse.statusCode(),
                        countryFlagResponse.body()
                );
            }
            FlagResponse response = objectMapper.readValue(countryFlagResponse.body(), FlagResponse.class);
            if (response.getError() == null ) {
                System.out.println("Error from API: " + response.getError());
            }

            return response;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
