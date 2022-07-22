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

import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Subject extends Auditable implements Domain {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name="created_by")
    private User created_by;

    public static void main(String[] args) {

        User user = User.builder()
                .fullname(new Fullname("VAli","mid","VAli"))
                .login(new Login("1","Vali"))
                .build();


        UserDao userDao = UserDao.getInstance();
        User user1 = userDao.find(2L).get();

        Subject subject = Subject.builder()
                .description("math")
                .name("Math")
                .created_by(user1)
                .build();

        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(subject);
        session.getTransaction().commit();
        session.close();

    }

}
