package uz.team_dev.back.domains.user;

import jakarta.persistence.*;
import lombok.*;

import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AuthUser")
public class User extends Auditable implements Domain {

    @Embedded
    private Fullname fullname;
    @Embedded
    private Login login;

    @Enumerated(EnumType.STRING)

    private Language language = Language.UZ;

    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    private boolean active = true;

    @Builder(builderMethodName = "childBuilder")
    public User(Long id, LocalDateTime created_at, LocalDateTime updated_at,
                boolean delete, Fullname fullname, Login login, Language language,
                Role role, boolean active) {
        super(id,created_at, updated_at, delete);
        this.fullname = fullname;
        this.login = login;
        this.language = language;
        this.role = role;
        this.active = active;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Statistics> statisticsList;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Quiz> quizzes;

}
