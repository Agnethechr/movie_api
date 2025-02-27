package app.Services;

import app.DTO.*;
import app.entity.Cast;
import app.entity.CrewMember;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
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

    public MediaDTO getAllMovies(String jsonResponse) {
        System.out.println("API Response: " + jsonResponse);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            List<GenreDTO> genres = new ArrayList<>();
            JsonNode genreArray = rootNode.path("genre_ids");
            for(JsonNode genreNode : genreArray) {

                int id = genreNode.asInt();
               // String name = genreNode.path("name").asText();
                genres.add(new GenreDTO(id));
            }

          CrewMemberDTO director = null;
            JsonNode crewArray = rootNode.path("credits").path("crew");
            if (crewArray.isArray()){
            for(JsonNode crewNode : crewArray){
                if("Director".equals(crewNode.path("job").asText())) {
                    director = new CrewMemberDTO(
                            crewNode.path("id").asInt(),
                            crewNode.path("name").asText());
                    break;
                }
                }
            }

            CastDTO actor = null;
            JsonNode castArray = rootNode.path("credits").path("cast");
            if (castArray.isArray()){
                for(JsonNode castNode : castArray){
                    if("Acting".equals(castNode.path("known_for_department").asText())) {
                        actor = new CastDTO(
                                castNode.path("id").asInt(),
                                castNode.path("name").asText());
                        break;
                    }
                }
            }


            String releaseDate = rootNode.path("release_date").asText();
            if(releaseDate == null || releaseDate.isEmpty()) {
                return new MediaDTO();
            }

            LocalDate releaseDateLocal = null;
            try {
                releaseDateLocal = LocalDate.parse(releaseDate);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                return new MediaDTO();
            }

            return MediaDTO.builder()
                    .title(rootNode.path("original_title").asText())
                    .overview(rootNode.path("overview").asText())
                    .releaseDate(releaseDateLocal)
                    .genres(genres)
                    .crewMember(director)
                    .cast(actor)
                    .build();


        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//JsonNode root = objectMapper.readTree(jsonResponse);
//JsonNode results = root.path("results"); // Hent listen af film
//            return objectMapper.readValue(results.toString(), new TypeReference<List<MediaDTO>>() {});