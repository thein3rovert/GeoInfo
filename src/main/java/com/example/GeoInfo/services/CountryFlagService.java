package com.example.GeoInfo.services;

import com.example.GeoInfo.dto.FlagResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

@Getter
@Service
public class CountryFlagService {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public FlagResponse getCountryFlag (String iso2) throws IOException, InterruptedException {
        try {
            // Fetch a single country flag
            String requestBody = String.format("{\"iso2\": \"%s\"}");
            System.out.println("Request Body: " + requestBody);
            HttpRequest flagRequest = HttpRequest.newBuilder()
                .uri(new URI("https://countriesnow.space/api/v0.1/countries/flag/images/"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            //Create the response
            HttpResponse<String> response = httpClient.send(flagRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                System.out.println("Fetching flag success");
                return new ObjectMapper().readValue(response.body(), FlagResponse.class);
            }else {
                System.out.println("Failed to fetch flag. Status code: " + response.statusCode());
                return new ObjectMapper().readValue(response.body(), FlagResponse.class);
            }
        } catch (Exception e) {
            e.printStackTrace(); //TODO: Change exception to custom later
            return null;
        }
    }

    private String getIso2CodeForCountry(String country) {
        switch (country.toLowerCase()) {
            case "albania":
                return "AL";
            case "nigeria":
                return "NG";
            default:
                return null;
        }
    }
}
