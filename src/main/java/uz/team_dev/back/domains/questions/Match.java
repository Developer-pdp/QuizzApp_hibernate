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
@AllArgsConstructor
@NoArgsConstructor

public class Match implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToOne
    private Quiz quiz_id;

    @Column(nullable = false)
    String question_body;
}
