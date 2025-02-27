package app.entity;

import app.DTO.CreditsDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
@Table(name = "credits")
public class Credits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-Many relation til Cast med korrekt join-tabel
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_cast",
            joinColumns = @JoinColumn(name = "credits_id"),
            inverseJoinColumns = @JoinColumn(name = "cast_id")
    )
    private List<Cast> cast = new ArrayList<>();

    // Many-to-Many relation til Crew
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_crew",
            joinColumns = @JoinColumn(name = "credits_id"),
            inverseJoinColumns = @JoinColumn(name = "crew_id")
    )
    private List<CrewMember> crew = new ArrayList<>();

    // One-to-One relation til Movie
    @OneToOne(mappedBy = "credits", cascade = CascadeType.ALL)
    private Movie movie;

}
