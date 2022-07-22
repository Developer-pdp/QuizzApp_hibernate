package uz.team_dev.back.vo.auth;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {
    private String username;
    private String password;
}
