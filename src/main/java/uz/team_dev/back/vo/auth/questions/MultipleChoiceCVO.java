package uz.team_dev.back.vo.auth.questions;

import lombok.*;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.vo.VO;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class MultipleChoiceCVO implements VO {
    private Long quiz_id;
    @Builder.Default
    private String uuid = UUID.randomUUID().toString();
    private String question_body;
}
