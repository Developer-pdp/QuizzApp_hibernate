package uz.team_dev.back.vo.auth.subject;

import lombok.*;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SubjectCVO implements VO {
    private String name;
    private String description;
    private Long created_by;
}
