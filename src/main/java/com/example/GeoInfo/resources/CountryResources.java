package com.example.GeoInfo.resources;

import com.example.GeoInfo.dto.CountryRequest;
import com.example.GeoInfo.dto.FlagResponse;
import com.example.GeoInfo.services.CountryFlagService;
import com.example.GeoInfo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/countries")
public class CountryResources {

    @Autowired
    private CountryFlagService countryFlagService;

    @PostMapping("/flag")
    public FlagResponse getCountryFlag(@RequestBody String country) throws IOException, InterruptedException {
        return countryFlagService.getCountryFlag(country);
    }
}
