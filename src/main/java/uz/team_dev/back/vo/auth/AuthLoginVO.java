package uz.team_dev.back.vo.auth;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginVO {
    private String username;
    private String password;
}
