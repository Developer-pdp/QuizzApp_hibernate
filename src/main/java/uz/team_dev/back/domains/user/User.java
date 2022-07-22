package uz.team_dev.back.domains.user;

import jakarta.persistence.*;
import lombok.*;

import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;

@Setter
@Getter
@Builder(builderClassName = "childBuilder")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AuthUser")
public class User extends Auditable implements Domain {

    @Embedded
    private Fullname fullname;
    @Embedded
    private Login login;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Language language = Language.UZ;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role = Role.STUDENT;

    @Builder.Default
    private boolean active = true;



}
