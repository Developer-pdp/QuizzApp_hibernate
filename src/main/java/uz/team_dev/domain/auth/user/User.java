package uz.team_dev.domain.auth.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team_dev.config.HibernateJavaConfigurer;
import uz.team_dev.domain.auth.quiz.Quiz;
import uz.team_dev.domain.auth.subject.Subject;
import uz.team_dev.domain.enums.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

@jakarta.persistence.Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class User implements uz.team_dev.domain.auth.Entity {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Builder.Default
   private UUID user_id = UUID.randomUUID();

   @Embedded
   private Fullname fullname;

   @Column(nullable = false)
   private String password;

   @Builder.Default
   @Enumerated(EnumType.STRING)
   private UserRole role = UserRole.STUDENT;

   @ColumnDefault(value = "0")
   private int is_active;

   @Column(name = "created_at")
   @CreationTimestamp
   private LocalDateTime created_at;

   @UpdateTimestamp
   private LocalDateTime updated_at;


   @Builder.Default
   private boolean is_deleted = false;

   private LocalDateTime blocked_till;
   private LocalDateTime first_attempt_time;

   @Builder.Default
   private int try_count = 0;


   public static void main(String[] args) {
//      createSubject("English");
//      createUser("Bek","Bekjon","Shelby","8899");
//        getSubject("Math");
      createQuiz("Math");
      createQuiz("English");
   }
   private static void createQuiz(String subject_name){
      Subject subject = getSubject(subject_name);
      Quiz quiz  = Quiz.builder()
              .subject(subject)
              .build();
      SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

      Session session = sessionFactory.openSession();
      session.getTransaction().begin();

      session.persist(quiz);

      session.getTransaction().commit();
      session.close();

   }
   private static void createUser(String username,String first_name,String last_name,String password){
      Fullname fullname1 = Fullname.builder()
              .first_name(first_name)
              .last_name(last_name)
              .username(username)
              .build();

      User user = User.builder()
              .fullname(fullname1)
              .password(password)
              .created_at(LocalDateTime.now())
              .build();
      SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

      Session session = sessionFactory.openSession();
      session.getTransaction().begin();

      session.persist(user);

      session.getTransaction().commit();
      session.close();

   }

   private static void createSubject(String name){
      Subject subject = Subject.builder()
              .name(name)
              .created_at(String.valueOf(LocalDateTime.now()))
              .status("ok")
              .build();

      SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();

      Session session = sessionFactory.openSession();
      session.getTransaction().begin();

      session.persist(subject);

      session.getTransaction().commit();
      session.close();
   }
   private static Subject getSubject(String name) {
      SessionFactory sessionFactory = HibernateJavaConfigurer.getSessionFactory();
      Session session = sessionFactory.openSession();
      session.getTransaction().begin();
      Query query = session.createQuery("select t from Subject t where t.name = ?1", Subject.class);
      query.setParameter(1, name);
      Subject singleResult = (Subject) query.getSingleResult();
      System.out.println("singleResult = " + singleResult);
      session.getTransaction().commit();
      session.close();
      return singleResult;
   }
}
