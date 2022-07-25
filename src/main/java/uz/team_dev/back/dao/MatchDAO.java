package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.Match;
import uz.team_dev.back.domains.user.User;

import java.util.List;
import java.util.Optional;

public class MatchDAO implements GenericDAO<Match>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    @Override
    public Optional<List<Match>> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Match> match = session.createQuery("select t from Match t ", Match.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(match);

    }

    @Override
    public Optional<Long> persist(Match entity) {
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
    public Optional<Boolean> update(Match entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();

    }

    @Override
    public Optional<Match> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from Match t where t.id =:id", Match.class);
        query.setParameter("id", id);
        Match singleResult = (Match) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }
}
