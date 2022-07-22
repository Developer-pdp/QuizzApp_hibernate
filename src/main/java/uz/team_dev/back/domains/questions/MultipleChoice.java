package uz.team_dev.back.domains.questions;

import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Domain;

@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "Multiple_choice")
@AllArgsConstructor
@NoArgsConstructor

public class MultipleChoice implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    long question_id;

    @Column(nullable = false)
    String question_body;

    @Column(nullable = false)
    long answer_id;
}
