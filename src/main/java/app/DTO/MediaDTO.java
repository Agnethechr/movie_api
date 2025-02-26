package app.DTO;

import app.entity.Genre;
import app.entity.Movie;
import app.entity.TvShow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.time.LocalDate;
import java.util.List;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaDTO {
    private int id;
    private String title;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("movie_results")
    private List<Movie> movieResults;
    @JsonProperty("tv_results")
    private List<TvShow> tvResults;
    @JsonProperty("tv_episode_results")
    private List<String> tvEpisodeResults;
    @JsonProperty("tv_season_results")
    private List<String> tvSeasonResults;
    @JsonProperty("genres")
    private List<GenreDTO> genres;
    private double popularity;
    @JsonProperty("vote_count")
    private int voteCount;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("poster_path")
    private String posterPath;
    private boolean adult;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    private boolean video;
    private String overview;
    private int budget;
    private int revenue;
    private int runtime;
    private String status;
    @JsonProperty("tagline")
    private String tagLine;
    @JsonProperty("original_language")
    private String originalLanguages;
    @JsonProperty("credits")
    private CreditsDTO credits;

    public MediaDTO(app.entity.Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.originalTitle = movie.getOriginalName();
        this.releaseDate = movie.getReleaseDate();
        this.popularity = movie.getPopularity();
        this.voteCount = movie.getVoteCount();
        this.voteAverage = movie.getVoteAverage();
        this.posterPath = movie.getPosterPath();
        this.adult = movie.isAdult();
        this.video = movie.isVideo();
        this.overview = movie.getOverview();
        this.budget = movie.getBudget();
        this.revenue = movie.getRevenue();
        this.runtime = movie.getRuntime();
        this.status = movie.getStatus();
        this.tagLine = movie.getTagLine();
        this.originalLanguages = movie.getOriginalLanguage();

        this.genres = movie.getGenres() != null ? movie
                .getGenres()
                .stream()
                .map(GenreDTO::new)
                .collect(java.util.stream.Collectors.toList()) : null;
        this.credits = movie.getCredits() != null ? new CreditsDTO(movie.getCredits()) : null;
    }
}