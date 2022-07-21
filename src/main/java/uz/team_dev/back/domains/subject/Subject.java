package uz.team_dev.back.domains.subject;

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

    private String description;
}
