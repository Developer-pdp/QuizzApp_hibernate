package uz.team_dev.domain.auth.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Fullname {

    private String first_name;
    private String last_name;

    @Column(unique = true)
    private String username;
}
