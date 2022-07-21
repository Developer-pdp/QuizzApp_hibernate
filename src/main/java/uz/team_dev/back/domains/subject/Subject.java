package uz.team_dev.back.domains.subject;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Subject {
    private long id;
    private String name;
    private String description;
}
