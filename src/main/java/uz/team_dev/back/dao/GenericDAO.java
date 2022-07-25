package uz.team_dev.back.dao;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.Domain;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class  GenericDAO<T extends Domain> {

    Gson gson = new Gson();

    private final SessionFactory SESSION_FACTORY = HibernateJavaConfigurer.getSessionFactory();
    private Session session;

    @SuppressWarnings("unchecked")
    private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass())
            .getActualTypeArguments()[0];

    public Optional<List<T>> findAll(String query){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        List<T> resultList = session.createQuery(query, clazz).getResultList();
        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(resultList);
    }

    public Optional<Boolean> persist(T entity){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.of(true);
    }

    public Optional<Boolean> delete(String query, Long id){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        Query query1 = session.createQuery(query);
        query1.setParameter("id",id);
        int i = query1.executeUpdate();
        System.out.println(i);
        session.getTransaction().commit();
        session.close();
        return Optional.of(true);
    }

    public Optional<Boolean> update(T entity){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
        return Optional.empty();

    }

    public Optional<T> find(String query, Long id){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();

        Query<T> query1 = session.createQuery(query, clazz);
        query1.setParameter("id", id);
        T singleResult = query1.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }

    public Optional<T> find(String query, String name){
        session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();

        Query<T> query1 = session.createQuery(
                query, clazz);
        query1.setParameter("name", name);
        T singleResult = query1.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(singleResult);
    }

}
