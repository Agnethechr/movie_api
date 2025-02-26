package app.DTO;

import app.entity.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenreDTO {
    private int id;
    private String name;

    public GenreDTO(Genre genre){
        this.id = genre.getId();
        this.name = genre.getName();
    }
}
