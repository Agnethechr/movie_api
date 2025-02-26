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
    private boolean adult;
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    @JsonProperty("original_name")
    private String originalName;
    private double popularity;
    @JsonProperty("profile_path")
    private String profilePath;
    private String character;
    @JsonProperty("credit_id")
    private String creditId;
    @JsonProperty("order")
    private int order;
    private int gender;

    public CastDTO(Cast cast){
        this.id = cast.getId();
        this.castId = cast.getCastId();
        this.name = cast.getName();
        this.adult = cast.isAdult();
        this.knownForDepartment = cast.getKnownForDepartment();
        this.originalName = cast.getOriginalName();
        this.popularity = cast.getPopularity();
        this.profilePath = cast.getProfilePath();
        this.character = cast.getCharacter();
        this.creditId = cast.getCreditId();
        this.order = cast.getOrder();
        this.gender = cast.getGender();
    }
}
