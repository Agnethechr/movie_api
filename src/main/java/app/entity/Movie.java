package app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {

    private Integer id;
    private String title;
    @JsonProperty("original_title")
    private String originalName;
    private String overview;
    @JsonProperty("media_type")
    private String mediaType;
    private boolean adult;
    @JsonProperty("original_language")
    private String originalLanguage;
    private Double popularity;
    @JsonProperty("release_date")
    private String releaseDate;
    private boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private Integer vote_count;
    }


