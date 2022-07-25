package uz.team_dev.back.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import uz.team_dev.back.config.HibernateJavaConfigurer;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;

import java.util.List;
import java.util.Optional;

/**
 * name : Abul_dev
 * date : 21, Thursday, 2022
 * project name : QuizzApp_hibernate
 */
public class SubjectDAO extends GenericDAO<Subject> {

    private static SubjectDAO instance;

    public static SubjectDAO getInstance() {
        if (instance == null) instance = new SubjectDAO();
        return instance;
    }

    public static void main(String[] args) {

        SubjectDAO subjectDAO = SubjectDAO.getInstance();

        UserDao userDao = UserDao.getInstance();


//        if (userDao.find("select t from User t where id = :id", 2L).isPresent()) {
//            User user1 = userDao.find("select t from User t where id = :id", 2L).get();

                Subject subject = Subject.childBuilder()
                        .name("math2")
                        .description("des")
                        .created_by(
                                userDao.find("select t from User t where id = :id",1L).get())
                        .build();

//                subjectDAO.persist(subject, subject.getId());

//            Subject subject = Subject.childBuilder()
//                    .id(5L)
//                    .description("math new")
//                    .name("Math new")
//                    .build();
//


//            Subject subject1 = subjectDAO.find("select t from Subject t where id = :id", 5L).get();

            subjectDAO.delete("update Subject  set delete = true where id = :id",6L);

//        }


    }

}
