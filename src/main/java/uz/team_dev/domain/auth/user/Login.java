package uz.team_dev.domain.auth.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Login {
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

}
