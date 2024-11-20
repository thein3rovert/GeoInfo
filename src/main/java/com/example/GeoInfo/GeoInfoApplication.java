package com.example.GeoInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@SpringBootApplication
public class GeoInfoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GeoInfoApplication.class, args);

	}

}
