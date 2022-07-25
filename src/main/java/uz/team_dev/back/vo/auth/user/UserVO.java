package uz.team_dev.back.vo.auth.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.vo.VO;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class UserVO implements VO {
    private Long id;
    private Fullname fullname;
    private String username;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private Language language;
    private Role role;
    private boolean active;

    public UserVO(User user) {
        this.id  = user.getId();
        this.fullname = user.getFullname();
        this.username = user.getLogin().getUsername();
        this.created_at = user.getCreated_at();
        this.updated_at = user.getUpdated_at();
        this.language = user.getLanguage();
        this.role = user.getRole();
        this.active = user.isActive();
    }

    public UserVO(UserCreateVO dto) {
        Language language1 = dto.getLanguage();
        Login login = dto.getLogin();
    }
}
