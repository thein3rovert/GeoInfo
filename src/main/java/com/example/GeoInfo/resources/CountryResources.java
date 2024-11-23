package com.example.GeoInfo.resources;

import com.example.GeoInfo.dto.CityPopulationResponse;
import com.example.GeoInfo.dto.CountryRequest;
import com.example.GeoInfo.dto.FlagResponse;
import com.example.GeoInfo.services.CountryFlagService;
import com.example.GeoInfo.services.CountryPopulationService;
import com.example.GeoInfo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/countries")
public class CountryResources {
    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryFlagService countryFlagService;
    @Autowired
    private CountryPopulationService countryPopulationService;


    @GetMapping("/capitals")
    public CountryRequest getCountriesAndCapital() {
        return countryService.getAllCountriesAndCapital();
    }

//    @PostMapping("/flag")
//    public ResponseEntity<?> getCountryFlag(@RequestBody Map<String, String> request) throws IOException, InterruptedException {
//        String countryName= request.get("country");
//        if (countryName == null || countryName.isEmpty()) {
//            return ResponseEntity.badRequest().body("ISO2 code is required");
//        }
//
//        FlagResponse response = countryFlagService.getCountryFlag(countryName);
//        if(response != null && !response.isError()) {
//            return ResponseEntity.ok(response);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Failed to fetch country flag. Please try again later.");
//       // return countryFlagService.getCountryFlag(iso2);
//    }

    @GetMapping("/flag")
    public FlagResponse getCountriesAndFlag() {
        return countryFlagService.getCountryFlag();
    }


    @GetMapping("population/cities")
    public CityPopulationResponse getCityPopulation() {
        return countryPopulationService.getCountryPopulation();
    }
}
