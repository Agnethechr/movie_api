package app.DTO;

import app.entity.Credits;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditsDTO {
    @JsonProperty("cast")
    private List<CastDTO> cast;
    @JsonProperty("crew")
    private List<CrewMemberDTO> crew;

    public CreditsDTO(Credits credits) {
        this.cast = credits.getCast() != null ? credits
                .getCast()
                .stream()
                .map(CastDTO::new)
                .collect(Collectors.toList()) : null;
        this.crew = credits.getCrew() != null ? credits
                .getCrew()
                .stream()
                .map(CrewMemberDTO::new)
                .collect(Collectors.toList()) : null;
    }
}
