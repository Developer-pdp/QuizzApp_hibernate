package uz.team_dev.back.mapper;

import org.jetbrains.annotations.NotNull;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.subject.Subject;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.auth.subject.SubjectCVO;
import uz.team_dev.back.vo.auth.subject.SubjectUVO;
import uz.team_dev.back.vo.auth.subject.SubjectVO;

import java.util.ArrayList;
import java.util.List;

public class SubjectMapper {
    private static SubjectMapper instance;
    private static final UserDao userDao = new UserDao();
    public static SubjectMapper getInstance() {
        if (instance == null) instance = new SubjectMapper();
        return instance;
    }

    public Subject fromCVOtoDomain(SubjectCVO dto) {

        User user = userDao.find(
                " select t from User t where t.id = :id",
                dto.getCreated_by()).get();

        return Subject.childBuilder()
                .name(dto.getName())
                .description(dto.getDescription())
                .created_by(user)
                .build();
    }

    public SubjectVO fromDomaintoVO(Subject Subject) {
        return new SubjectVO(Subject);
    }

    public Subject fromUVOtoDomain(@NotNull SubjectUVO dto) {
        return Subject.childBuilder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public List<SubjectVO> fromDomainListtoVOList(List<Subject> Subjects) {

        List<SubjectVO> SubjectVOS = new ArrayList<>();

        for (Subject Subject : Subjects) {
            SubjectVOS.add(new SubjectVO(Subject));
        }
        return SubjectVOS;
    }

}
