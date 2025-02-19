package app.entity;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@Data
public class TvShow {
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

    @JsonProperty("vote_average")
    private Number voteAverage;

    @JsonProperty("vote_count")
    private Integer voteCount;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("origin_country")
    private List<String> originCountry;
}
