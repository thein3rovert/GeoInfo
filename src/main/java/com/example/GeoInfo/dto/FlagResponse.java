package com.example.GeoInfo.dto;

import com.example.GeoInfo.Entity.FlagEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlagResponse {
    private String error;
    private String msg;
    //private FlagEntity data;
    private List<FlagEntity> data;
}
