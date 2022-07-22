package uz.team_dev.back.domains.questions;

import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Domain;

@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "Re_order")
@AllArgsConstructor
@NoArgsConstructor

public class ReOrder implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long question_id;

    @Column(nullable = false)
    private String question_body;

    @Column(nullable = false)
    private String answer_body;
}
