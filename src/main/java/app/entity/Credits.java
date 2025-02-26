package app.entity;

import app.DTO.CreditsDTO;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cast_id")
    private List<Cast> cast;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "crew_id")
    private List<CrewMember> crew;

    @OneToOne(mappedBy = "credits")
    private Movie movie;

    public Credits(CreditsDTO creditsDTO) {
        if (creditsDTO.getCast() != null) {
            this.cast = creditsDTO
                    .getCast()
                    .stream()
                    .map(Cast::new)
                    .collect(Collectors.toList());
        } else {
            this.cast = null;
        }
        if (creditsDTO.getCrew() != null) {
            this.crew = creditsDTO
                    .getCrew()
                    .stream()
                    .map(CrewMember::new)
                    .collect(Collectors.toList());
        } else {
            this.crew = null;
        }
    }
}
