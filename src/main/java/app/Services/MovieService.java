package app.Services;

import app.DTO.MediaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class MovieService {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public String getDataFromURL(String url) {
        //String cityURL = url.replace("%%", city);
        try {
            // Create an HttpClient instance
            HttpClient client = HttpClient.newHttpClient();

            // Create a request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the status code and print the response
            if (response.statusCode() == 200) {
                String body = response.body();
                // System.out.println(body);
                return body;
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MediaDTO getMovieById(String json) {
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        try {
            MediaDTO movieDTO = objectMapper.readValue(json, MediaDTO.class);
            return movieDTO;
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public MediaDTO getAllMovies(String json) {
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        try {
            MediaDTO movieDTO = objectMapper.readValue(json, MediaDTO.class);
            return movieDTO;
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}

