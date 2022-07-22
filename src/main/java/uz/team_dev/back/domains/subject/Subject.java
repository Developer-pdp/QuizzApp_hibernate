package uz.team_dev.back.domains.subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import uz.team_dev.back.domains.Auditable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Subject extends Auditable {

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Long created_by;

}
