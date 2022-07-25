package uz.team_dev.back.service;

import uz.team_dev.back.dao.AnswerDAO;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.mapper.AnswerMapper;
import uz.team_dev.back.vo.auth.questions.AnswerCVO;
import uz.team_dev.back.vo.auth.questions.AnswerUVO;
import uz.team_dev.back.vo.auth.questions.AnswerVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.List;
import java.util.Optional;

public class AnswerService implements GenericService<AnswerVO,AnswerCVO, AnswerUVO, Long> {

    AnswerDAO answerDAO = AnswerDAO.getInstance();

     AnswerMapper mapper = AnswerMapper.getInstance();

    private static AnswerService instance;

    public static AnswerService getInstance() {
        if (instance == null) instance = new AnswerService();
        return instance;
    }

    @Override
    public Response<Data<Long>> persist(AnswerCVO dto) {
        MultipleChoiceAnswer choice = mapper.fromCVOtoDomain(dto);
        if (answerDAO.persist(choice).get()){
            return new Response<>(new Data<>(-1L));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                " not persisted ",
                " not persisted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> delete(Long id) {
        Optional<Boolean> delete = answerDAO.delete("update MultipleChoiceAnswer set delete = true where id = :id",id);
        if (delete.isPresent()) {
            return new Response<>(new Data<>(true));
        }
        return new Response<>(new Data<>(new Data.ErrorVO(
                "not deleted",
                "not deleted",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> update(AnswerUVO dto) {

//        Optional<MultipleChoiceAnswer> multipleChoice = answerDAO.find("select t from MultipleChoiceAnswer t where id = :id", dto.getId());
//
//        if (multipleChoice.isPresent()) {
//
//            MultipleChoiceAnswer multipleChoice1 = multipleChoice.get();
//
//            String question_body = dto.getQuestion_body();
//            Quiz quiz_id = dto.getQuiz_id();
//
//
//            if (question_body != null) multipleChoice1.setQuestion_body(question_body);
//
//
//            if (quiz_id != null) multipleChoice1.setQuiz_id(quiz_id);
//
//            Optional<Boolean> update = answerDAO.update(multipleChoice1);
//
//            if (update.isPresent()){
//                return new Response<>(new Data<>(true));
//            }
//        }
        return new Response<>(new Data<>(new Data.ErrorVO(
                " not updated ",
                " not updated ",
                400
        )));
    }

    @Override
    public Response<Data<AnswerVO>> find(Long id) {
        Optional<MultipleChoiceAnswer> multipleChoice = answerDAO.find(
                " select t from MultipleChoiceAnswer t where t.id = :id",
                id);

        return multipleChoice.map(choice -> new Response<>(new Data<>(mapper.fromDomaintoVO(choice)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoice not found by id",
                " multipleChoice not found by id",
                404
        ))));

    }

    @Override
    public Response<Data<AnswerVO>> find(String uuid) {
        Optional<MultipleChoiceAnswer> multipleChoice = answerDAO.find(
                " select t from MultipleChoiceAnswer t where t.uuid = :name",
                uuid);

        return multipleChoice.map(choice -> new Response<>(new Data<>(mapper.fromDomaintoVO(choice)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoice not found by id",
                " multipleChoice not found by id",
                404
        ))));
    }


    @Override
    public Response<Data<List<AnswerVO>>> findAll() {
        Optional<List<MultipleChoiceAnswer>> list = answerDAO.findAll("select t from MultipleChoiceAnswer t");
        return list.map(multipleChoiceList -> new Response<>(new Data<>(mapper.fromDomainListtoVOList(multipleChoiceList)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoices not found",
                " multipleChoices not found",
                404
        ))));
    }

}
