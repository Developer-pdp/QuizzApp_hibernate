package uz.team_dev.back.domains;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class Auditable {
    @Id
    private Long id;

    @Builder.Default
    private UUID entity_id = UUID.randomUUID();

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @Builder.Default
    private boolean delete = false;

}
