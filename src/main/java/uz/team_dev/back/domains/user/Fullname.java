package uz.team_dev.back.domains.user;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fullname {
    private String first_name;
    private String middle_name;
    private String last_name;
}
