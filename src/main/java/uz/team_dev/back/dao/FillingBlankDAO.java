package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.FillingBlank;
import uz.team_dev.back.domains.questions.ReOrder;

import java.util.List;
import java.util.Optional;

public class FillingBlankDAO extends GenericDAO<FillingBlank> {

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
        List<FillingBlank> filling = session.createQuery("select t from FillingBlank t ", FillingBlank.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(filling);

    }

    @Override
    public Optional<Boolean> persist(FillingBlank entity) {
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
    public Optional<Boolean> update(FillingBlank entity) {
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
        Query query = session.createQuery("select t from FillingBlank t where t.id =:id", FillingBlank.class);
        query.setParameter("id", id);
        FillingBlank singleResult = (FillingBlank) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }
}
