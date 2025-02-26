package app.DTO;

import app.entity.CrewMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrewMemberDTO {
    @JsonIgnore
    private int id;
    @JsonProperty("id")
    private int crewId;
    private String name;
    private String department;
    private String job;
    @JsonProperty("profile_path")
    private String profilePath;
    private boolean adult;
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    @JsonProperty("original_name")
    private String originalName;
    private double popularity;
    @JsonProperty("credit_id")
    private String creditId;

    public CrewMemberDTO(CrewMember crewMember) {
        this.id = crewMember.getId();
        this.crewId = crewMember.getCrewId();
        this.name = crewMember.getName();
        this.department = crewMember.getDepartment();
        this.job = crewMember.getJob();
        this.profilePath = crewMember.getProfilePath();
        this.adult = crewMember.isAdult();
        this.gender = crewMember.getGender();
        this.knownForDepartment = crewMember.getKnownForDepartment();
        this.originalName = crewMember.getOriginalName();
        this.popularity = crewMember.getPopularity();
        this.creditId = crewMember.getCreditId();
    }
}
