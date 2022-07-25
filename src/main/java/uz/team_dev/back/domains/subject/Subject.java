package uz.team_dev.back.domains.subject;

import com.zaxxer.hikari.util.SuspendResumeLock;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cascade;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Subject extends Auditable implements Domain {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User created_by;

    @Builder(builderMethodName = "childBuilder")
    public Subject(Long id,LocalDateTime created_at, LocalDateTime updated_at,
                   boolean delete, String name, String description, User created_by) {
        super(id,  created_at, updated_at, delete);
        this.name = name;
        this.description = description;
        this.created_by = created_by;
    }


}
