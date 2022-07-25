package uz.team_dev.back.vo.auth.questions;

import lombok.*;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.vo.VO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MultipleChoiceUVO implements VO {
    private Long id;
    private String uuid;
    private Quiz quiz_id;
    private String question_body;
}
