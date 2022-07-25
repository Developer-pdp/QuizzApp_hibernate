package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.domains.user.User;

import java.util.List;
import java.util.Optional;

public class MultipleChoiceDAO implements GenericDAO<MultipleChoice>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }


    @Override
    public Optional<List<MultipleChoice>> getAll() {        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<MultipleChoice> multiple = session.createQuery("select t from MultipleChoice t ", MultipleChoice.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(multiple);
    }

    @Override
    public Optional<Long> persist(MultipleChoice entity) {
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
    public Optional<Boolean> update(MultipleChoice entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();
    }

    @Override
    public Optional<MultipleChoice> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from MultipleChoice t where t.id =:id", MultipleChoice.class);
        query.setParameter("id", id);
        MultipleChoice singleResult = (MultipleChoice) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }
}
