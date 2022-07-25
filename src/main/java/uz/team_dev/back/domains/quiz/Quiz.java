package uz.team_dev.back.domains.quiz;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Quiz implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private UUID user_id = UUID.randomUUID();

    @Embedded
    private Fullname fullname;

    @Embedded
    private Login login;
    @Column(nullable = false)
    private Language language;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

    @ColumnDefault(value = "0")
    private int is_active;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;


    @Builder.Default
    private boolean delete = false;

    private LocalDateTime blocked_till;
    private LocalDateTime first_attempt_time;

    @Builder.Default
    private int try_count = 0;

}
