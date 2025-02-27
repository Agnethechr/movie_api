package app.DTO;

import app.entity.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO {
    @JsonProperty("genre_ids")
    private int id;
    private String name;

    public GenreDTO(Genre genre){
        this.id = genre.getId();
        this.name = genre.getName();
    }

    public GenreDTO(int id) {
    }
}
