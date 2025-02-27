package app.DTO;

import app.entity.Genre;
import app.entity.Movie;
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
    private LocalDate releaseDate;
    @JsonProperty("movie_results")
    private List<Movie> movieResults;
    @JsonProperty("genre_ids")
    private List<Integer> genresIds;
    private String overview;
    @JsonProperty("original_language")
    private String originalLanguages;
    @JsonProperty("credits")
    private CreditsDTO credits;
    @JsonProperty("genres")
    private List<GenreDTO> genres;
    private CrewMemberDTO crewMember;
    private CastDTO cast;
    private GenreDTO genre;

    public MediaDTO(Movie movie) {
    }
}