package uz.team_dev.back.mapper;

import org.jetbrains.annotations.NotNull;
import uz.team_dev.back.dao.QuizDAO;
import uz.team_dev.back.dao.SubjectDAO;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.vo.auth.quiz.QuizCVO;
import uz.team_dev.back.vo.auth.quiz.QuizUVO;
import uz.team_dev.back.vo.auth.quiz.QuizVO;
import java.util.ArrayList;
import java.util.List;

public class QuizMapper {

    UserDao userDao = UserDao.getInstance();
    SubjectDAO subjectDAO = SubjectDAO.getInstance();

    public Quiz fromCVOtoDomain(QuizCVO dto) {
        return Quiz.childBuilder()
                .name(dto.getName())
                .level(dto.getLevel())
                .created_by(userDao.find("select t from User t where id = :id ",dto.getCreated_by()).get())
                .subject_id(subjectDAO.find("select t from Subject t where id = :id",dto.getSubject_id()).get())
                .build();
    }

    public QuizVO fromDomaintoVO(Quiz quiz) {
        return new QuizVO(quiz);
    }

    public Quiz fromUVOtoDomain(@NotNull QuizUVO dto) {
        return Quiz.childBuilder()
                .id(dto.getId())
                .name(dto.getName())
                .level(dto.getLevel())
                .subject_id(subjectDAO.find("select t from Subject where id = :id",dto.getSubject_id()).get())
                .build();
    }

    public List<QuizVO> fromDomainListtoVOList(List<Quiz> Quizs) {

        List<QuizVO> QuizVOS = new ArrayList<>();

        for (Quiz Quiz : Quizs) {
            QuizVOS.add(new QuizVO(Quiz));
        }
        return QuizVOS;
    }
}
