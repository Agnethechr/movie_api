package app.entity;
import app.DTO.GenreDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "genres")
public class Genre {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies = new ArrayList<>();

    public Genre(GenreDTO genreDTO) {
        this.id = genreDTO.getId();
        this.name = genreDTO.getName();
    }
}