package app.DTO;

import app.entity.TvShow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private Integer id;

    @JsonProperty("name")
    private String title;

    @JsonProperty("original_name")
    private String originalTitle;

    private String overview;

    @JsonProperty("media_type")
    private String mediaType;

    private boolean adult;

    @JsonProperty("original_language")
    private String originalLanguage;

    private Double popularity;

    @JsonProperty("first_air_date")
    private String releaseDate;

    private boolean video;

    @JsonProperty("vote_average")
    private Number voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;

    @JsonProperty("tv_results")
    private List<TvShow> tvResults;

    @JsonProperty("tv_episode_results")
    private List<String> tvEpisodeResults;

    @JsonProperty("tv_season_results")
    private List<String> tvSeasonResults;


    public MovieDTO getMovieDTO(String json) {
        try {
            MovieDTO movieDTO = objectMapper.readValue(json, MovieDTO.class);

            return movieDTO;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public MovieDTO getMovieById(String json) {
        objectMapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        try {
            System.out.println("JSON Response: " + json);  // Debug-log
            MovieDTO movieDTO = objectMapper.readValue(json, MovieDTO.class);
            System.out.println("Parsed MovieDTO: " + movieDTO); // Debug-log
            return movieDTO;
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

}
