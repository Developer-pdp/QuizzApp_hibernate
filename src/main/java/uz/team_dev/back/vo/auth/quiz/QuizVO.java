package uz.team_dev.back.vo.auth.quiz;

import lombok.*;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuizVO implements VO {
    private String name;
    private User created_by;
    private User updated_by;
    private Level level;
    private Subject subject_id;
    private Long id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public QuizVO(Quiz quiz) {
        this.name = quiz.getName();
        this.created_by = quiz.getCreated_by();
        this.updated_by = quiz.getUpdated_by();
        this.level = quiz.getLevel();
        this.subject_id = quiz.getSubject_id();
        this.id = quiz.getId();
        this.created_at = quiz.getCreated_at();
        this.updated_at = quiz.getUpdated_at();
    }
}
