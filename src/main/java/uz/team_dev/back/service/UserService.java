package uz.team_dev.back.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uz.team_dev.back.dao.UserDao;

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





}
