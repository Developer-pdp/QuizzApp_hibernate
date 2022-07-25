package uz.team_dev.back.mapper;

import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.auth.user.UserCreateVO;
import uz.team_dev.back.vo.auth.user.UserUVO;
import uz.team_dev.back.vo.auth.user.UserVO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private static UserMapper instance;

    public static UserMapper getInstance() {
        if (instance == null) instance = new UserMapper();
        return instance;
    }

    public User fromCVOtoUser(UserCreateVO dto) {
        return User.childBuilder()
                .fullname(dto.getFullname())
                .login(dto.getLogin())
                .language(dto.getLanguage())
                .role(dto.getRole())
                .build();
    }

    public UserVO fromDomaintoVO(User user) {
        return new UserVO(user);
    }

    public List<UserVO> fromDomainListtoVOList(List<User> users) {

        List<UserVO> userVOS = new ArrayList<>();

        for (User user : users) {
            userVOS.add(new UserVO(user));
        }
        return userVOS;
    }


    public User fromUVOtoDomain(UserUVO dto) {
        return null;
    }
}
