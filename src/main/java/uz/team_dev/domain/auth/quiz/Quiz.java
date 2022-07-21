package uz.team_dev.domain.auth.quiz;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private UUID quiz_id = UUID.randomUUID();


}
