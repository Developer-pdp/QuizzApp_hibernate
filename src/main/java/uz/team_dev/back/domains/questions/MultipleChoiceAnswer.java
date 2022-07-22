package uz.team_dev.back.domains.questions;


import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Domain;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class MultipleChoiceAnswer implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long multiple_choice_id;

    @Column(nullable = false)
    private String answer_body;
}
