package app.entity;

import app.DTO.MediaDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "movie")
public class Movie {
    @Id
    private Integer id;
    private String title;
    private String imdbId;
    private String originalName;
    private String overview;
    private String mediaType;
    private boolean adult;
    private String originalLanguage;
    private double popularity;
    private String releaseDate;
    private boolean video;
    private double voteAverage;
    private int voteCount;
    private String posterPath;
    private String backdropPath;
    private int budget;
    private int revenue;
    private int runtime;
    private String status;
    private String tagLine;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    @Transient
    private List<OriginalLanguages> spokenLanguages;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id")
    private List<Genre> genres = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "credits_id")
    private Credits credits;

    private void addGenre(Genre genre) {
        if(genres != null) {
            this.genres.add(genre);
            genre.getMovies().add(this);
        }else
        genres = new ArrayList<>();
    }

    public Movie(MediaDTO mediaDTO) {
        this.id = mediaDTO.getId();
        this.title = mediaDTO.getTitle();
        this.originalName = mediaDTO.getOriginalTitle();
        this.overview = mediaDTO.getOverview();
        this.adult = mediaDTO.isAdult();
        this.originalLanguage = mediaDTO.getOriginalLanguages();
        this.popularity = mediaDTO.getPopularity();
        this.releaseDate = mediaDTO.getReleaseDate();
        this.video = mediaDTO.isVideo();
        this.voteAverage = mediaDTO.getVoteAverage();
        this.voteCount = mediaDTO.getVoteCount();
        this.imdbId = mediaDTO.getImdbId();
        this.posterPath = mediaDTO.getPosterPath();
        this.backdropPath = mediaDTO.getBackdropPath();
        this.budget = mediaDTO.getBudget();
        this.revenue = mediaDTO.getRevenue();
        this.runtime = mediaDTO.getRuntime();
        this.status = mediaDTO.getStatus();
        this.tagLine = mediaDTO.getTagLine();
        mediaDTO.getGenres().forEach(genreDTO -> addGenre(new Genre(genreDTO)));
        this.credits = mediaDTO.getCredits() != null ? new Credits(mediaDTO.getCredits()) : null;

    }
}


