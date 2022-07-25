package uz.team_dev.back.vo.auth.subject;

import lombok.*;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class SubjectVO implements VO {
    private Long id;
    private String entity_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String name;
    private String description;
    private User created_by;

    public SubjectVO(Subject subject){
        this.id = subject.getId();
        this.created_at = subject.getCreated_at();
        this.updated_at = subject.getUpdated_at();
        this.name = subject.getName();
        this.description = subject.getDescription();
        this.created_by = subject.getCreated_by();
    }

}
