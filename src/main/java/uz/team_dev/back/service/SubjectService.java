package uz.team_dev.back.service;

import uz.team_dev.back.dao.SubjectDAO;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.questions.MultipleChoice;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.mapper.SubjectMapper;
import uz.team_dev.back.vo.auth.subject.SubjectCVO;
import uz.team_dev.back.vo.auth.subject.SubjectUVO;
import uz.team_dev.back.vo.auth.subject.SubjectVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.List;
import java.util.Optional;

public class SubjectService implements GenericService<SubjectVO, SubjectCVO, SubjectUVO, Long> {

    private static SubjectService instance;

    public static SubjectService getInstance() {
        if (instance == null) instance = new SubjectService();
        return instance;
    }

    private static final SubjectMapper subjectMapper = new SubjectMapper();
    private static final UserDao userDao = new UserDao();

    private static final SubjectDAO subjectDAO = new SubjectDAO();

    @Override
    public Response<Data<Long>> persist(SubjectCVO dto) {
        Subject subject = subjectMapper.fromCVOtoDomain(dto);
        if (subjectDAO.persist(subject).get()){

            Subject subject1 = subjectDAO.find("select t from Subject t where name = :name", dto.getName()).get();

            return new Response<>(new Data<>(subject1.getId()));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                " not persisted ",
                " not persisted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> delete(Long id) {
        Optional<Boolean> delete = subjectDAO.delete("update Subject set delete = true where id = :id",id);
        if (delete.isPresent()) {
            return new Response<>(new Data<>(true));
        }
        return new Response<>(new Data<>(new Data.ErrorVO(
                " not deleted ",
                " not deleted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> update(SubjectUVO dto) {

        Optional<Subject> subject = subjectDAO.find("select t from Subject t where id = :id", dto.getId());

        if (subject.isPresent()) {

            Subject subject1 = subject.get();

            String description = dto.getDescription();
            String name = dto.getName();

            if (description != null) {
                subject1.setDescription(description);
            }

            if (name != null) subject1.setName(name);

            Optional<Boolean> update = subjectDAO.update(subject1);

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
    public Response<Data<SubjectVO>> find(Long id) {
        Optional<Subject> subject = subjectDAO.find(
                " select t from Subject t where t.id = :id",
                id);
        return subject.map(subject1 -> new Response<>(new Data<>(subjectMapper.fromDomaintoVO(subject1)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " subject not found by id",
                " subject not found by id",
                404
        ))));
    }

    @Override
    public Response<Data<SubjectVO>> find(String name) {
        Optional<Subject> subject = subjectDAO.find(" select t from Subject t where t. t.name = :name", name);
        return subject.map(s -> new Response<>(new Data<>(subjectMapper.fromDomaintoVO(s)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " subject not found by name",
                " subject not found by name",
                404
        ))));

    }

    @Override
    public Response<Data<List<SubjectVO>>> findAll() {
        Optional<List<Subject>> list = subjectDAO.findAll("select t from Subject t");
        return list.map(subjectList -> new Response<>(new Data<>(subjectMapper.fromDomainListtoVOList(subjectList)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " subjects not found",
                " subjects not found",
                404
        ))));
    }
}
