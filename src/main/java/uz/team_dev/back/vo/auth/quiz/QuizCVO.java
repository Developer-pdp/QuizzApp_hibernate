package uz.team_dev.back.vo.auth.quiz;

import lombok.*;
import uz.team_dev.back.dao.SubjectDAO;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.vo.VO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuizCVO implements VO {

    private String name;
    private Long created_by;
    private Level level;
    private Long subject_id;
}
