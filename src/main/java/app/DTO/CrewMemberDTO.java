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
    private int gender;
    @JsonProperty("known_for_department")
    private String knownForDepartment;


    public CrewMemberDTO(int id, String name) {
    }

    public CrewMemberDTO(CrewMember crewMember) {
    }
}
