package com.example.GeoInfo.dto;

import com.example.GeoInfo.Entity.CountryEntity;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@Getter
@Data
public class CountryResponse {
        private List<CountryEntity> data;
        private String error;
        private String msg;
}
