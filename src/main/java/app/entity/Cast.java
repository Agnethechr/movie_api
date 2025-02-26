package app.entity;

import app.DTO.CastDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
@Table(name = "cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String character;
    private int castId;
    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private double popularity;
    private String profilePath;
    private String creditId;
    private int order;
    @ManyToMany(mappedBy = "cast")
    private List<Credits> credits;

    public Cast(CastDTO castDTO){
        this.id = castDTO.getId();
        this.character = castDTO.getCharacter();
        this.castId = castDTO.getCastId();
        this.adult = castDTO.isAdult();
        this.gender = castDTO.getGender();
        this.knownForDepartment = castDTO.getKnownForDepartment();
        this.name = castDTO.getName();
        this.originalName = castDTO.getOriginalName();
        this.popularity = castDTO.getPopularity();
        this.profilePath = castDTO.getProfilePath();
    }
}
