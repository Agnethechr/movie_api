package app.DTO;

import app.entity.OriginalLanguages;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginalLanguageDTO {
    @JsonProperty("iso_639_1")
    private String iso6391;
    private String name;
    @JsonProperty("english_name")
    private String englishName;

    public OriginalLanguageDTO(OriginalLanguages originalLanguage) {
        this.iso6391 = originalLanguage.getIso6391();
        this.name = originalLanguage.getName();
        this.englishName = originalLanguage.getEnglishName();
    }
}
