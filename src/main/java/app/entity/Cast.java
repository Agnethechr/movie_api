package app.entity;

import app.DTO.CastDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
@Table(name = "cast_members")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String character;
    private int castId;
    private int gender;
    private String knownForDepartment;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "movie_cast",  // Ny join-tabel
            joinColumns = @JoinColumn(name = "cast_id"),
            inverseJoinColumns = @JoinColumn(name = "credits_id")
    )
    private List<Credits> credits = new ArrayList<>();

}
