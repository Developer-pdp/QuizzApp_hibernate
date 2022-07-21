package uz.team_dev.back.domains.quiz;


import jakarta.persistence.*;
import lombok.*;
import uz.team_dev.back.domains.Auditable;
import uz.team_dev.back.domains.Domain;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Level;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Quiz extends Auditable implements Domain {

    @Column(nullable = false)
    private Long subject_id;

    private Long created_by;

    private Long updated_by;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Level level = Level.EASY;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Language language = Language.UZ;

    @Column(nullable = false)
    private int code;
}
