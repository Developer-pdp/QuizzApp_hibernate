package uz.team_dev.back.dao;


import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.mapper.UserMapper;
import uz.team_dev.back.service.UserService;
import uz.team_dev.back.vo.auth.user.LoginVO;
import uz.team_dev.back.vo.auth.user.UserUVO;
import uz.team_dev.front.ui.UserSession;

import java.util.Optional;

public class UserDao extends GenericDAO<User> {

    private final SessionFactory SESSION_FACTORY = HibernateJavaConfigurer.getSessionFactory();

    private final UserMapper USER_MAPPER = new UserMapper();

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    public Optional<User> login(@NotNull LoginVO loginVO) {

        Session session = SESSION_FACTORY.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("select t from User t where t.login.username = :username and t.login.password = :password", User.class);

        query.setParameter("username", loginVO.getUsername());
        query.setParameter("password", loginVO.getPassword());

        User user =(User) query.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return Optional.ofNullable(user);
    }


    public static void main(String[] args) {

        UserDao userDao = UserDao.getInstance();
        UserService userService = UserService.getInstance();
        User user = User.childBuilder()
                .fullname(new Fullname("Ali", "ALi", "ALi"))
                .login(new Login("ali","ali"))
                .role(Role.STUDENT)
                .language(Language.EN)
                .build();

        userService.update(UserUVO.builder()
                        .id(1L)
                        .fullname(new Fullname("u","u","u"))
                        .login(new Login("u","u"))
                .build());




    }


}
