package uz.team_dev.back.domains.user;

import lombok.*;

import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements Domain {
    private long id;
    private String username;
    private String password;
    private Language language;
    private Role role;
    private boolean active;
}
