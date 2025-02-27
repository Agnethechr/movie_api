package app.entity;
import app.DTO.GenreDTO;
import jakarta.persistence.*;
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

    @ManyToMany(mappedBy = "genres", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Movie> movies = new ArrayList<>();



}