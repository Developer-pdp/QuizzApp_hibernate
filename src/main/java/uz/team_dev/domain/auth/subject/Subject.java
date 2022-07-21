package uz.team_dev.domain.auth.subject;


import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.domain.auth.quiz.Quiz;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@jakarta.persistence.Entity
@Table(name = "subject")
public class Subject implements uz.team_dev.domain.auth.Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "subject")
    private List<Quiz> quiz;

    private String name ;

    private String status;

    private Long created_by;

    private String created_at;

    private String updated_at;

    private Long updated_by;

    private Boolean is_deleted;
}

