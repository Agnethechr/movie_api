package app.entity;

import app.DTO.CrewMemberDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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
    private boolean adult;
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    private double popularity;
    @JsonProperty("profile_path")
    private String profilePath;
    private String creditId;
    private String job;
    private String department;

    @ManyToMany(mappedBy = "crew")
    private List<Credits> credits;

    public CrewMember(CrewMemberDTO crewMemberDTO) {
        this.id = crewMemberDTO.getId();
        this.crewId = crewMemberDTO.getCrewId();
        this.adult = crewMemberDTO.isAdult();
        this.gender = crewMemberDTO.getGender();
        this.knownForDepartment = crewMemberDTO.getKnownForDepartment();
        this.name = crewMemberDTO.getName();
        this.originalName = crewMemberDTO.getOriginalName();
        this.popularity = crewMemberDTO.getPopularity();
        this.profilePath = crewMemberDTO.getProfilePath();
        this.creditId = crewMemberDTO.getCreditId();
        this.job = crewMemberDTO.getJob();
        this.department = crewMemberDTO.getDepartment();
    }
}
