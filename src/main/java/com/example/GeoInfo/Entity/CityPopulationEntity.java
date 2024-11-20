package com.example.GeoInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityPopulationEntity {
    private String city;
    private String country;
    private List<PopulationCountEntity> populationCounts;
}
