package com.example.GeoInfo.dto;

import com.example.GeoInfo.Entity.CityPopulationEntity;
import lombok.Data;

import java.util.List;

@Data
public class CityPopulationResponse {
    private boolean error;
    private String msg;
    private List<CityPopulationEntity> data;
}
