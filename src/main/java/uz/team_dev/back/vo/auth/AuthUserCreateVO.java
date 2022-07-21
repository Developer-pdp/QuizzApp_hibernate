package uz.team_dev.back.vo.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthUserCreateVO {
    private String username;
    private String password;
    private String language;
}
