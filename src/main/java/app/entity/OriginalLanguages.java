package app.entity;

import app.DTO.OriginalLanguageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
@Table(name = "original_languages")
public class OriginalLanguages {
    @Id
    private String iso6391;
    private String name;
    private String englishName;

    public OriginalLanguages(OriginalLanguageDTO originalLanguageDTO) {
        this.iso6391 = originalLanguageDTO.getIso6391();
        this.name = originalLanguageDTO.getName();
        this.englishName = originalLanguageDTO.getEnglishName();
    }
}
