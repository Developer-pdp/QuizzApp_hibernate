package uz.team_dev.back.dao;


import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.auth.LoginVO;
import uz.team_dev.back.vo.auth.UserVO;

import java.util.List;
import java.util.Optional;

public class UserDao implements GenericDAO<User> {

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }


    @Override
    public Optional<List<User>> getAll() {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<User> users = session.createQuery("select t from User t ", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(users);

    }

    @Override
    public Optional<Long> persist(User entity) {
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
    public Optional<Boolean> update(User entity) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();

    }

    @Override
    public Optional<User> find(Long id) {
        SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from User t where t.id =:id", User.class);
        query.setParameter("id", id);
        User user = (User) query.getSingleResult();
        System.out.println("user = " + user);
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(user);

    }

    public Optional<UserVO> login(LoginVO loginVO) {
        return Optional.empty();
    }
}
