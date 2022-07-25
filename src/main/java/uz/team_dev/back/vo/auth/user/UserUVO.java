package uz.team_dev.back.vo.auth.user;

import lombok.*;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.vo.VO;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserUVO implements VO {

    private Long id;
    private Fullname fullname;
    private Login login;
    private Language language;

}
