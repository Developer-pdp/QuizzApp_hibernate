package uz.team_dev.back.vo.auth.subject;

import lombok.*;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectUVO implements VO {
    private Long id;
    private String name;
    private String description;



}
