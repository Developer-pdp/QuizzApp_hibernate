package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.FillingBlank;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.questions.ReOrder;

import java.util.List;
import java.util.Optional;

public class AnswerDAO implements GenericDAO<MultipleChoiceAnswer>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    @Override
    public Optional<List<ReOrder>> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<MultipleChoiceAnswer> answer = session.createQuery("select t from MultipleChoiceAnswer t ", MultipleChoiceAnswer.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(answer);

    }

    @Override
    public Optional<Long> persist(MultipleChoiceAnswer entity) {
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
        return Optional.empty();    }

    @Override
    public Optional<Boolean> update(MultipleChoiceAnswer entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();
    }

    @Override
    public Optional<FillingBlank> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from MultipleChoiceAnswer t where t.id =:id", MultipleChoiceAnswer.class);
        query.setParameter("id", id);
        MultipleChoiceAnswer singleResult = (MultipleChoiceAnswer) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }
}
