package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.ReOrder;

import java.util.List;
import java.util.Optional;

public class ReOrderDAO implements GenericDAO<ReOrder>{

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
        List<ReOrder> reOrders = session.createQuery("SELECT a FROM ReOrder a", ReOrder.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(reOrders);
    }

    @Override
    public Optional<Long> persist(ReOrder entity) {
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
    public Optional<Boolean> update(ReOrder entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.getTransaction().commit();
        session.close();
        return Optional.empty();
    }

    @Override
    public Optional<ReOrder> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from ReOrder t where t.id =:id", ReOrder.class);
        query.setParameter("id", id);
        ReOrder singleResult = (ReOrder) query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }

}
