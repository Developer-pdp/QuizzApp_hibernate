package uz.team_dev.back.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.vo.auth.LoginVO;
import uz.team_dev.back.vo.auth.UserVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    UserDao userDao = UserDao.getInstance();

    private static UserService instance;



    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    public Response<Data<Long>> persist(User user) {

        Optional<Long> persist = userDao.persist(user);

        return persist.map(aLong -> new Response<>(new Data<>(aLong))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                "User can not persist",
                "User can not persist",
                500))));
    }

    public Response<Data<UserVO>> login(LoginVO loginVO) {
        Optional<UserVO> login = userDao.login(loginVO);
        return login.map(userVO -> new Response<>(new Data<>(userVO))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                "Bad credentials",
                "username or password wrong",
                600
        ))));
    }
}
