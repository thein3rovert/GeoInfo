package com.example.GeoInfo.resources;

import com.example.GeoInfo.dto.CityPopulationResponse;
import com.example.GeoInfo.dto.CountryResponse;
import com.example.GeoInfo.dto.FlagResponse;
import com.example.GeoInfo.services.CountryFlagService;
import com.example.GeoInfo.services.CountryPopulationService;
import com.example.GeoInfo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CountryResponse getCountriesAndCapital() {
        return countryService.getAllCountriesAndCapital();
    }



    @GetMapping("/flag")
    public FlagResponse getCountriesAndFlag() {
        return countryFlagService.getCountryFlag();
    }


    @GetMapping("population/cities")
    public CityPopulationResponse getCityPopulation() {
        return countryPopulationService.getCountryPopulation();
    }
}
