package uz.team_dev.back.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.questions.ReOrder;

import java.util.List;
import java.util.Optional;

public class ReOrderDAO extends GenericDAO<ReOrder>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }



}
