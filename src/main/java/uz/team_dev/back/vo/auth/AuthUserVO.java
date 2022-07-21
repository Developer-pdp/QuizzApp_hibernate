package uz.team_dev.back.vo.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;


@Getter
@Setter
@Builder
public class AuthUserVO {
    private long id;
    private String username;
    private Language language;
    private Role role;
}
