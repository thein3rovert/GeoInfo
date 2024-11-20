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
		 //Http client for getting the request
		HttpRequest getRequest = HttpRequest.newBuilder()
				//.uri(new URI("https://countriesnow.space/api/v0.1/countries/capital"))
				// Flag image
				.uri(new URI("https://countriesnow.space/api/v0.1/countries/flag/images"))
				.GET()
				.build();
		// Http client for sending the request
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

		//Print the response to the console
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}
	}

