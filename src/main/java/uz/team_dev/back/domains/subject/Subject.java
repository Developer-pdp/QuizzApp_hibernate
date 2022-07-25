package uz.team_dev.back.domains.subject;

import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Domain;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Subject implements Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;


}
