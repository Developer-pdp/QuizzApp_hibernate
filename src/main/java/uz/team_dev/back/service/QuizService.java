package uz.team_dev.back.service;

import uz.team_dev.back.dao.QuizDAO;
import uz.team_dev.back.dao.SubjectDAO;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Level;
import uz.team_dev.back.mapper.QuizMapper;
import uz.team_dev.back.vo.auth.quiz.QuizCVO;
import uz.team_dev.back.vo.auth.quiz.QuizUVO;
import uz.team_dev.back.vo.auth.quiz.QuizVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.List;
import java.util.Optional;

public class QuizService implements GenericService<QuizVO, QuizCVO, QuizUVO, Long> {

    private static QuizService instance;

    public static QuizService getInstance() {
        if (instance == null) {
            instance = new QuizService();
        }
        return instance;
    }

    private static final QuizMapper quizMapper = new QuizMapper();

    private static final QuizDAO quizDAO = new QuizDAO();
    private static final SubjectDAO subjectDAO = SubjectDAO.getInstance();

    @Override
    public Response<Data<Long>> persist(QuizCVO dto) {

        Quiz quiz = quizMapper.fromCVOtoDomain(dto);
        if (quizDAO.persist(quiz).get()){

            Quiz quiz1 = quizDAO.find("select t from Quiz t where name = :name", dto.getName()).get();

            return new Response<>(new Data<>(quiz1.getId()));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                " not persisted ",
                " not persisted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> delete(Long id) {
//        Optional<Boolean> delete = quizDAO.delete(id);
//        if (delete.isPresent()){
//            return new Response<>(new Data<>(true));
//        }
        return new Response<>(new Data<>(new Data.ErrorVO(
                " not deleted ",
                " not deleted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> update(QuizUVO dto) {

        Optional<Quiz> quiz = quizDAO.find("select t from Quiz t where id = :id", dto.getId());

        if (quiz.isPresent()) {

            Quiz quiz1 = quiz.get();

            Level level = dto.getLevel();
            String name = dto.getName();
            Long subject_id = dto.getSubject_id();


            if (level != null) quiz1.setLevel(level);

            if (name != null) quiz1.setName(name);

            if (subject_id != null) quiz1.setSubject_id(subjectDAO.find("select t from Subject where id = :id",subject_id).get());

            Optional<Boolean> update = quizDAO.update(quiz1);

            if (update.isPresent()) {
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
    public Response<Data<QuizVO>> find(Long id) {
        Optional<Quiz> quiz = quizDAO.find(
                " select t from User t where t.fullname.first_name = :name or t.fullname.last_name = :name or t.fullname.middle_name = :name",
                id);
        return quiz.map(quiz1 -> new Response<>(new Data<>(quizMapper.fromDomaintoVO(quiz1)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " subject not found by id",
                " subject not found by id",
                404
        ))));
    }

    @Override
    public Response<Data<QuizVO>> find(String name) {
        Optional<Quiz> quiz = quizDAO.find(" select t from Quiz t where t.name = :name", name);
        return quiz.map(quiz1 -> new Response<>(new Data<>(quizMapper.fromDomaintoVO(quiz1)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " quiz not found by name",
                " quiz not found by name",
                404
        ))));

    }

    @Override
    public Response<Data<List<QuizVO>>> findAll() {
        Optional<List<Quiz>> list = quizDAO.findAll("select t from Quiz t");
        return list.map(subjectList -> new Response<>(new Data<>(quizMapper.fromDomainListtoVOList(subjectList)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " quizzes not found",
                " quizzes not found",
                404
        ))));
    }
}
