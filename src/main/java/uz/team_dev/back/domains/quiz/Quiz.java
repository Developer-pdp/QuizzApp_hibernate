package uz.team_dev.back.domains.quiz;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.dao.SubjectDAO;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.mapper.SubjectMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Quiz extends Auditable implements Domain {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne(targetEntity = User.class)
    @JoinColumn
    private User created_by;

    @OneToOne(targetEntity = User.class)
    @JoinColumn
    private User updated_by;

    @Enumerated(EnumType.STRING)
    private Level level = Level.EASY;

    @ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
    @JoinColumn
    private Subject subject_id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    List<MultipleChoice> multipleChoiceList;

    @Builder(builderMethodName = "childBuilder")
    public Quiz(Long id, String uuid, LocalDateTime created_at, LocalDateTime updated_at, boolean delete,
                String name, User created_by, User updated_by, Level level, Subject subject_id) {
        super(id, created_at, updated_at, delete);
        this.name = name;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.level = level;
        this.subject_id = subject_id;
    }

    public Quiz(String name, User created_by, User updated_by, Level level, Subject subject_id) {
        this.name = name;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.level = level;
        this.subject_id = subject_id;
    }


}
