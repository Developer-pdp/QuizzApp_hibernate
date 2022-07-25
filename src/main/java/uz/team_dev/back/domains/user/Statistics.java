package uz.team_dev.back.domains.user;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import uz.team_dev.back.domains.quiz.Quiz;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "Stat")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User user_id;

    @ManyToOne
    private Quiz quiz_id;

    private Integer score;

    private Integer max_score;

    @Formula(value = "max_score-score")
    private Short rate;

    @CreationTimestamp
    LocalDateTime created_at;

}
