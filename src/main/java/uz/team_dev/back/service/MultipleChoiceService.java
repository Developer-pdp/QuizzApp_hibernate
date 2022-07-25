package uz.team_dev.back.service;

import uz.team_dev.back.dao.MultipleChoiceDAO;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.mapper.MultipleChoiceMapper;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceUVO;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceVO;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceCVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.List;
import java.util.Optional;

public class MultipleChoiceService implements GenericService<MultipleChoiceVO, MultipleChoiceCVO, MultipleChoiceUVO,Long> {


    MultipleChoiceDAO multipleChoiceDAO = MultipleChoiceDAO.getInstance();

    MultipleChoiceMapper mapper = MultipleChoiceMapper.getInstance();

    private static MultipleChoiceService instance;

    public static MultipleChoiceService getInstance() {
        if (instance == null) instance = new MultipleChoiceService();
        return instance;
    }

    @Override
    public Response<Data<Long>> persist(MultipleChoiceCVO dto) {
        MultipleChoice choice = mapper.fromCVOtoDomain(dto);
        if (multipleChoiceDAO.persist(choice).get()){

            MultipleChoice choice1 = multipleChoiceDAO.find("select t from MultipleChoice t where t.uuid = :name", dto.getUuid()).get();

            return new Response<>(new Data<>(choice1.getId()));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                " not persisted ",
                " not persisted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> delete(Long id) {
        Optional<Boolean> delete = multipleChoiceDAO.delete("update MultipleChoice set delete = true where id = :id",id);
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
    public Response<Data<Boolean>> update(MultipleChoiceUVO dto) {

        Optional<MultipleChoice> multipleChoice = multipleChoiceDAO.find("select t from MultipleChoice t where id = :id", dto.getId());

        if (multipleChoice.isPresent()) {

            MultipleChoice multipleChoice1 = multipleChoice.get();

            String question_body = dto.getQuestion_body();
            Quiz quiz_id = dto.getQuiz_id();


            if (question_body != null) multipleChoice1.setQuestion_body(question_body);


            if (quiz_id != null) multipleChoice1.setQuiz_id(quiz_id);

            Optional<Boolean> update = multipleChoiceDAO.update(multipleChoice1);

            if (update.isPresent()){
                return new Response<>(new Data<>(true));
            }
        }
        return new Response<>(new Data<>(new Data.ErrorVO(
                " not updated ",
                " not updated ",
                400
        )));
    }

    @Override
    public Response<Data<MultipleChoiceVO>> find(Long id) {
        Optional<MultipleChoice> multipleChoice = multipleChoiceDAO.find(
                " select t from MultipleChoice t where t.id = :id",
                id);

        return multipleChoice.map(choice -> new Response<>(new Data<>(mapper.fromDomaintoVO(choice)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoice not found by id",
                " multipleChoice not found by id",
                404
        ))));

    }

    @Override
    public Response<Data<MultipleChoiceVO>> find(String uuid) {
        Optional<MultipleChoice> multipleChoice = multipleChoiceDAO.find(
                " select t from MultipleChoice t where t.uuid = :name",
                uuid);

        return multipleChoice.map(choice -> new Response<>(new Data<>(mapper.fromDomaintoVO(choice)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoice not found by id",
                " multipleChoice not found by id",
                404
        ))));
    }


    @Override
    public Response<Data<List<MultipleChoiceVO>>> findAll() {
        Optional<List<MultipleChoice>> list = multipleChoiceDAO.findAll("select t from MultipleChoice t");
        return list.map(multipleChoiceList -> new Response<>(new Data<>(mapper.fromDomainListtoVOList(multipleChoiceList)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " multipleChoices not found",
                " multipleChoices not found",
                404
        ))));
    }
}
