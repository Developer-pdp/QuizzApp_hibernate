package uz.team_dev;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.config.HibernateJavaConfigurer;
import uz.team_dev.domain.auth.quiz.Quiz;
import uz.team_dev.domain.auth.subject.Subject;
import uz.team_dev.domain.auth.user.Fullname;
import uz.team_dev.domain.auth.user.User;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
//      createSubject("English");
//      createUser("Bek","Bekjon","Shelby","8899");
//        getSubject("Math");
        createQuiz("Math");
        createQuiz("English");
    }
    private static void createQuiz(String subject_name){
        Subject subject = getSubject(subject_name);
        Quiz quiz  = Quiz.builder()
                .subject(subject)
                .build();
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(quiz);

        session.getTransaction().commit();
        session.close();

    }
    private static void createUser(String username,String first_name,String last_name,String password){
        Fullname fullname1 = Fullname.builder()
                .first_name(first_name)
                .last_name(last_name)
                .username(username)
                .build();

        User user = User.builder()
                .fullname(fullname1)
                .password(password)
                .created_at(LocalDateTime.now())
                .build();
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(user);

        session.getTransaction().commit();
        session.close();

    }

    private static void createSubject(String name){
        Subject subject = Subject.builder()
                .name(name)
                .created_at(String.valueOf(LocalDateTime.now()))
                .status("ok")
                .build();

        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();

        session.persist(subject);

        session.getTransaction().commit();
        session.close();
    }
    private static Subject getSubject(String name) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from Subject t where t.name = ?1", Subject.class);
        query.setParameter(1, name);
        Subject singleResult = (Subject) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return singleResult;
    }

}
