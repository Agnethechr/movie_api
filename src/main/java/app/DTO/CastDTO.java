package app.DTO;


import app.entity.Cast;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CastDTO {
    @JsonIgnore
    private int id;
    @JsonProperty("id")
    private int castId;
    private String name;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String character;
    private int gender;


    public CastDTO(int id, String name) {
    }
}
