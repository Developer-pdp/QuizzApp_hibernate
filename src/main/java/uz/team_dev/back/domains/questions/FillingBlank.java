package uz.team_dev.back.domains.questions;

import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.quiz.Quiz;

@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "Fill_in_the_blank")
@AllArgsConstructor
@NoArgsConstructor

public class FillingBlank implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Quiz quiz_id;

    @Column(nullable = false)
    private String question_body;

    @Column(nullable = false)
    private String answer_body;

}
