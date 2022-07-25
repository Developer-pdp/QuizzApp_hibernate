package uz.team_dev.back.domains.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Login {

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
