package uz.team_dev.back.vo.auth.questions;

import jakarta.persistence.Entity;
import jdk.jfr.Name;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.vo.VO;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class AnswerVO implements VO {

    private Long id;
    private MultipleChoice multiple_choice_id;
    private String answer_body;
    private boolean isTrue;

}

