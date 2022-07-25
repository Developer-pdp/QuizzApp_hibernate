package uz.team_dev.back.vo.auth.quiz;

import lombok.*;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.vo.VO;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class   QuizUVO implements VO {
    private Long id;
    private String name;
    private Level level;
    private Long subject_id;
}
