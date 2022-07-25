package uz.team_dev.back.vo.auth.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.vo.VO;

@Getter
@Setter
@Builder
public class UserCreateVO implements VO {
    private Fullname fullname;
    private Login login;
    @Builder.Default
    private Language language = Language.UZ;
    private Role role;
}
