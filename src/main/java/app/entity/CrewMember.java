package app.entity;

import app.DTO.CrewMemberDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "crew_member")
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int crewId;
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    private String job;
    private String department;

    // Many-to-Many relation til Credits med korrekt join-tabel
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "movie_crew",
            joinColumns = @JoinColumn(name = "crew_id"),
            inverseJoinColumns = @JoinColumn(name = "credits_id")
    )
    private List<Credits> credits = new ArrayList<>();


    public CrewMember(CrewMemberDTO crewMemberDTO) {
    }
}
