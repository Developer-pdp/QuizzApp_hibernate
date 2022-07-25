package uz.team_dev.back.vo.auth.questions;

import lombok.*;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class MultipleChoiceVO implements VO {

    private Long id;
    private String uuid;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Quiz quiz_id;
    private String question_body;

}
