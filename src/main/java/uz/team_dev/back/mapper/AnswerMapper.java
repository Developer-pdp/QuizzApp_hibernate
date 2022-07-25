package uz.team_dev.back.mapper;

import uz.team_dev.back.dao.MultipleChoiceDAO;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.vo.auth.questions.AnswerCVO;
import uz.team_dev.back.vo.auth.questions.AnswerVO;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceVO;

import java.util.List;

public class AnswerMapper {

    private static final MultipleChoiceDAO dao = MultipleChoiceDAO.getInstance();

    private static AnswerMapper instance;

    public static AnswerMapper getInstance() {
        if (instance == null) instance = new AnswerMapper();
        return instance;
    }

    public AnswerVO fromDomaintoVO(MultipleChoiceAnswer choice) {
        return null;
    }

    public List<AnswerVO> fromDomainListtoVOList(List<MultipleChoiceAnswer> multipleChoiceList) {
        return null;
    }

    public MultipleChoiceAnswer fromCVOtoDomain(AnswerCVO dto) {

        return MultipleChoiceAnswer.builder()
                .answer_body(dto.getAnswer_body())
                .multiple_choice_id(dao.find("select t from MultipleChoice t where t.id = :id",dto.getMultiple_choice_id()).get())
                .build();
    }
}
