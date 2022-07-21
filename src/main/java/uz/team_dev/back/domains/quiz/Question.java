package uz.team_dev.back.domains.quiz;

import lombok.*;
import uz.jl.back.enums.Language;
import uz.jl.back.enums.Level;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Question {
    private long id;
    private String questionBody;
    private Language language;
    private Level level;
    private String subjectId;
}
