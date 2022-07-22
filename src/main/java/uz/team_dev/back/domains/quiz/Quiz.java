package uz.team_dev.back.domains.quiz;


import lombok.*;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Level;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Quiz implements Domain {
    private long id;
    private String userId;
    private String subjectId;
    private Level level;
    private Language language;
    private int count;
    private boolean completed;
}
