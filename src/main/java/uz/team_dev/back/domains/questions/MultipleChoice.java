package uz.team_dev.back.domains.questions;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.quiz.Quiz;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
@Table(name = "Multiple_choice")
@NoArgsConstructor

public class MultipleChoice extends Auditable implements Domain {

    @ManyToOne
    private Quiz quiz_id;


    @Column(name = "uuid", unique = true)
    private String uuid;

    @Column(nullable = false)
    private String question_body;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<MultipleChoiceAnswer> answers;

    @Builder(builderMethodName = "childBuilder")
    public MultipleChoice(Long id, String uuid,  LocalDateTime created_at, LocalDateTime updated_at,
                          boolean delete, Quiz quiz_id, String question_body) {
        super(id, created_at, updated_at, delete);
        this.quiz_id = quiz_id;
        this.question_body = question_body;
        this.uuid = uuid;
    }


}
