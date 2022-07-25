package uz.team_dev.front.ui;

import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.mapper.MultipleChoiceMapper;
import uz.team_dev.back.service.AnswerService;
import uz.team_dev.back.service.MultipleChoiceService;
import uz.team_dev.back.vo.auth.questions.AnswerCVO;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceCVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.utils.Reader;
import uz.team_dev.back.vo.utils.Writer;

import java.util.Scanner;

public class QuestionPage {

    private static final MultipleChoiceService choiceService = MultipleChoiceService.getInstance();
    private static final AnswerService answerService = AnswerService.getInstance();

    private static final Scanner intscanner = new Scanner(System.in);

    public static void questionsCreate(int count, Long quiz_id) {

        for (int i = 0; i < count; i++) {
            Writer.printlnMiddle(i + 1 + " - question ");
            createOneQuestion(quiz_id);

        }

    }

    private static void createOneQuestion(Long quiz_id) {

        MultipleChoiceCVO cvo = MultipleChoiceCVO.builder()
                .quiz_id(quiz_id)
                .question_body(Reader.readLineMiddle("Enter question body => "))
                .build();

        Data<Long> data = choiceService.persist(cvo).getData();

        if (data.isSuccess()) {

            Long question_id = data.getBody();

            Writer.printMiddle("How many answers => ");

            int count = intscanner.nextInt();

            createAnswers(count, question_id);

            Writer.printlnMiddle("Answers successfully created");

        }

        Writer.printlnMiddle("Question successfully created");
        Reader.readLineMiddle("Press any key to back");

    }

    private static void createAnswers(int count, Long question_id) {

        for (int i = 0; i < count; i++) {
            Writer.printlnMiddle(i + 1 + " - answer");
            if (i == 0) {
                Writer.printlnMiddle("Enter true answer");
                createOneAnswer(question_id, true);
            } else {
                createOneAnswer(question_id, false);
            }
        }

    }

    private static void createOneAnswer(Long question_id, boolean isTrue) {
        AnswerCVO answerCVO = new AnswerCVO();
        answerCVO.setAnswer_body(Reader.readLineMiddle("Enter answer body => "));
        answerCVO.setMultiple_choice_id(question_id);
        answerCVO.setTrue(isTrue);

        Data<Long> data = answerService.persist(answerCVO).getData();

        if (data.isSuccess()){
            Writer.printlnMiddle("Successfully persisted");
        }
        else {
            Writer.printlnMiddleERR(data.getError().getFriendlyMessage());
        }

        Reader.readLineMiddle("Press any key to back");

    }
}
