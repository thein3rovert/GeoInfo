package com.example.GeoInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopulationCountEntity {
    private String year;
    private String value;
}