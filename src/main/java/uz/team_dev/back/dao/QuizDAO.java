package uz.team_dev.back.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.subject.Subject;

import java.util.List;
import java.util.Optional;

/**
 * name : Abul_dev
 * date : 21, Thursday, 2022
 * project name : QuizzApp_hibernate
 */
public class QuizDAO implements GenericDAO<Quiz> {


    private static SubjectDAO instance;

    public static SubjectDAO getInstance() {
        if (instance == null) instance = new SubjectDAO();
        return instance;
    }



    @Override
    public Optional<List<Quiz>> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Quiz> quiz = session.createQuery("select t from Quiz t  ", Quiz.class).getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("quiz = " + quiz);
        return Optional.ofNullable(quiz);


    }

    @Override
    public Optional<Long> persist(Quiz entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.remove(id);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();

    }

    @Override
    public Optional<Boolean> update(Quiz entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();

    }

    @Override
    public Optional<Quiz> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from Quiz t where t.id =:id", Quiz.class);
        query.setParameter("id", id);
        Quiz quiz =(Quiz) query.getSingleResult();
        System.out.println("quiz = " + quiz);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(quiz);
    }
}
