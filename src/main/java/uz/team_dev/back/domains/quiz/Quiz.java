package uz.team_dev.back.domains.quiz;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Level;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID user_id = UUID.randomUUID();
    @Column(nullable = false)
    private Long subject_id;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private Long created_by;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime updated_at;
    @UpdateTimestamp
    private Long updated_by;
    @Column(nullable = false)
    private Level level;
    @Column(nullable = false)
    private Language language;
    @Column(nullable = false)
    private int code;
}
