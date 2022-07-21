package uz.team_dev.back.domains.quiz;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class QuizQuestion {
    private long id;
    private String questionId;
    private String quizId;
    private boolean correct;
}
