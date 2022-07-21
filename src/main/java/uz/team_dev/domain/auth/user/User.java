package uz.team_dev.domain.auth.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

   @Embedded
   private Login login;

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
}
