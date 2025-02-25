package app.DTO;

import app.entity.Genre;
import app.entity.Movie;
import app.entity.TvShow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDate;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaDTO {
    @JsonProperty("firstairdate")
    private LocalDate releaseDate;

    @JsonProperty("movie_results")
    private List<Movie> movieResults;

    @JsonProperty("tv_results")
    private List<TvShow> tvResults;

    @JsonProperty("tv_episode_results")
    private List<String> tvEpisodeResults;

    @JsonProperty("tv_season_results")
    private List<String> tvSeasonResults;

    @JsonProperty("genres")
    private List<Genre> genres;

    @JsonProperty("original_language")
    private String originalLanguages;

}