package uz.team_dev.back.mapper;

import uz.team_dev.back.dao.MultipleChoiceDAO;
import uz.team_dev.back.dao.QuizDAO;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceCVO;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceVO;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceMapper {

    MultipleChoiceDAO dao = MultipleChoiceDAO.getInstance();
    QuizDAO quizDAO = QuizDAO.getInstance();

    private static MultipleChoiceMapper instance;

    public static MultipleChoiceMapper getInstance() {

        if (instance == null) instance = new MultipleChoiceMapper();

        return instance;
    }

    public MultipleChoiceVO fromDomaintoVO(MultipleChoice multipleChoice1) {
        return MultipleChoiceVO.builder()
                .id(multipleChoice1.getId())
                .created_at(multipleChoice1.getCreated_at())
                .updated_at(multipleChoice1.getUpdated_at())
                .question_body(multipleChoice1.getQuestion_body())
                .quiz_id(multipleChoice1.getQuiz_id())
                .build();
    }

    public List<MultipleChoiceVO> fromDomainListtoVOList(List<MultipleChoice> multipleChoiceList) {

        List<MultipleChoiceVO> multipleChoiceVOS = new ArrayList<>();

        for (MultipleChoice multipleChoice : multipleChoiceList) {
            multipleChoiceVOS.add(fromDomaintoVO(multipleChoice));
        }

        return multipleChoiceVOS;
    }

    public MultipleChoice fromCVOtoDomain(MultipleChoiceCVO dto) {


        return MultipleChoice.childBuilder()
                .question_body(dto.getQuestion_body())
                .quiz_id(quizDAO.find("select t from Quiz t where t.id = :id", dto.getQuiz_id()).get())
                .uuid(dto.getUuid())
                .build();


    }
}
