package com.example.GeoInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@SpringBootApplication
public class GeoInfoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GeoInfoApplication.class, args);
		// Http client for getting the request
//		HttpRequest getRequest = HttpRequest.newBuilder()
//				//.uri(new URI("https://countriesnow.space/api/v0.1/countries/capital"))
//				.uri(new URI("https://countriesnow.space/api/v0.1/countries/flag/images"))
//				.GET()
//				.build();
//		// Http client for sending the request
//		HttpClient client = HttpClient.newHttpClient();
//		HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
//
//		//Print the response to the console
//		System.out.println(response.statusCode());
//		System.out.println(response.body());
//	}

//		String iso2 = "NG"; // Example ISO2 code for Nigeria
//
//		String requestBody = String.format("{\"iso2\": \"%s\"}", iso2);
//		try {
//
//			// Define the URL for the API endpoint
//
//			URL url = new URL("https://countriesnow.space/api/v0.1/countries/flag/images");
//
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Type", "application/json");
//			conn.setDoOutput(true);
//			// Send the request body
//			try (OutputStream os = conn.getOutputStream()) {
//				os.write(requestBody.getBytes("UTF-8"));
//				os.flush();
//			}
//
//			// Check the response code
//			int responseCode = conn.getResponseCode();
//			System.out.println("Response Code: " + responseCode);
//
//			// Read the response
//			if (responseCode == HttpURLConnection.HTTP_OK) {
//				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				String inputLine;
//				StringBuilder response = new StringBuilder();
//				while ((inputLine = in.readLine()) != null) {
//					response.append(inputLine);
//
//				}
//
//				in.close();
//
//
//				// Print the response
//
//				System.out.println("Response: " + response.toString());
//
//			} else {
//
//				System.out.println("Failed to fetch flag. Status code: " + responseCode);
//
//
//
//				// Log the response for debugging
//
//				BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//
//				StringBuilder errorResponse = new StringBuilder();
//
//				String errorLine;
//
//				while ((errorLine = errorReader.readLine()) != null) {
//
//					errorResponse.append(errorLine);
//
//				}
//
//				errorReader.close();
//
//				System.out.println("Error Response: " + errorResponse.toString());
//
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
	}

}
