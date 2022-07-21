package uz.team_dev.back.domains.user;

import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User extends Auditable implements Domain {

    @Embedded
    private Fullname fullname;
    @Embedded
    private Login login;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.STUDENT;

    @Column(columnDefinition = "boolean default true")
    private boolean active;
}
