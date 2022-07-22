package uz.team_dev.back.domains.quiz;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Level;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "childBuilder")
@ToString
@Entity
public class Quiz extends Auditable implements Domain {


    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name="created_by")
    private User created_by;

    @OneToOne
    @JoinColumn(name="updated_by")
    private User updated_by;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Level level = Level.EASY;

    @Column(nullable = false)
    private Integer code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    public static void main(String[] args) {

//        Subject subject = Subject.builder()
//                .description("math")
//                .name("Math2")
//                .created_by(null)
//                .build();
//
//        Quiz quiz = Quiz.builder()
//                .name("Math 15")
//                .subject(subject)
//                .created_by(null)
//                .build();
//
//        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.persist(quiz);
//        session.getTransaction().commit();
//        session.close();

    }
}
