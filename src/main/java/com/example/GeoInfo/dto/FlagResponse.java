package com.example.GeoInfo.dto;

import com.example.GeoInfo.Entity.FlagEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlagResponse {
    private String name;
    private String iso2;
    private String data;
}
