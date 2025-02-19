package app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {

    private Integer id;
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    private String overview;
    @JsonProperty("media_type")
    private String mediaType;
    private boolean adult;
    @JsonProperty("original_language")
    private String originalLanguage;
    private Double popularity;
    @JsonProperty("first_air_date")
    private String firstAirDate;
    private boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    private Integer vote_count;
    private ArrayList<String> person_results;
    @JsonProperty("tv_results")
    private List<TvShow> tvResults;
    private ArrayList<String> tv_episode_results;
    private ArrayList<String> tv_season_results;
    private ArrayList<Movie> movie_results;


}
