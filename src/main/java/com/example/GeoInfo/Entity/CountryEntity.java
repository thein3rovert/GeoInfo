package com.example.GeoInfo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryEntity {
    private String name;
    private String capital;
}

