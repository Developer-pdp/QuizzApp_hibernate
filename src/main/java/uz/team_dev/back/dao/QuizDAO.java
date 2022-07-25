package uz.team_dev.back.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.enums.Level;

import java.util.List;
import java.util.Optional;

/**
 * name : Abul_dev
 * date : 21, Thursday, 2022
 * project name : QuizzApp_hibernate
 */
public class QuizDAO extends GenericDAO<Quiz> {


    private static QuizDAO instance;

    public static QuizDAO getInstance() {
        if (instance == null) instance = new QuizDAO();
        return instance;
    }

    public static void main(String[] args) {

        UserDao userDao = UserDao.getInstance();
        SubjectDAO subjectDAO = SubjectDAO.getInstance();
        QuizDAO quizDao = QuizDAO.getInstance();

        System.out.println(subjectDAO.find("select t from Subject t where t.id = :id", 2L).get());

        Quiz build = Quiz.childBuilder()
                .name("math 15")
                .level(Level.EASY)
                .created_by(
                        userDao.find("select t from User t where id = :id", 1L).get()
                )
                .subject_id(
                        subjectDAO.find("select t from Subject t where t.id = :id", 2L).get()
                )
                .build();

//        quizDao.persist(build);

        Optional<Quiz> quiz = quizDao.find("select t from Quiz t where t.id = :id", 1L);
        System.out.println(quiz.get());


    }


}
