package uz.team_dev.back.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.quiz.Quiz;
import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.mapper.UserMapper;
import uz.team_dev.back.vo.auth.user.LoginVO;
import uz.team_dev.back.vo.auth.user.UserCreateVO;
import uz.team_dev.back.vo.auth.user.UserUVO;
import uz.team_dev.back.vo.auth.user.UserVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.response.Response;

import java.util.List;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService implements GenericService<UserVO, UserCreateVO, UserUVO, Long> {


    private static final UserMapper userMapper = UserMapper.getInstance();

    UserDao userDao = UserDao.getInstance();

    private static UserService instance;


    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Response<Data<UserVO>> login(LoginVO loginVO) {

        Optional<User> login = userDao.login(loginVO);

        if (login.isPresent()) {
            UserVO userVO = userMapper.fromDomaintoVO(login.get());
            return new Response<>(new Data<>(userVO));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                "Bad credentials",
                "username or password wrong",
                600
        )));

    }

    @Override
    public Response<Data<Long>> persist(UserCreateVO dto) {

        User user = userMapper.fromCVOtoUser(dto);
        if (userDao.persist(user).get()){

           User user1 = userDao.find("select t from User t where t.username = :name", dto.getLogin().getUsername()).get();

            return new Response<>(new Data<>(user1.getId()));
        }

        return new Response<>(new Data<>(new Data.ErrorVO(
                " not persisted ",
                " not persisted ",
                400
        )));
    }

    @Override
    public Response<Data<Boolean>> delete(Long id) {
        Optional<Boolean> delete = userDao.delete("update User set delete = true where id = :id",id);
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
    public Response<Data<Boolean>> update(UserUVO dto) {

        Optional<User> user = userDao.find("select t from User t where id = :id", dto.getId());

        if (user.isPresent()) {

            User user1 = user.get();

            Language language = dto.getLanguage();
            Login login = dto.getLogin();
            Fullname fullname = dto.getFullname();


            if (language != null) {
                user1.setLanguage(language);
            }

            if (login != null) user1.setLogin(login);

            if (fullname != null) user1.setFullname(fullname);

            Optional<Boolean> update = userDao.update(user1);

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
    public Response<Data<UserVO>> find(Long id) {
        Optional<User> user = userDao.find(
                " select t from User t where t.id = :id",
                id);
        return user.map(user1 -> new Response<>(new Data<>(userMapper.fromDomaintoVO(user1)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " user not found by id",
                " user not found by id",
                404
        ))));
    }

    @Override
    public Response<Data<UserVO>> find(String name) {
        Optional<User> user = userDao.find(" select t from User t where t.fullname.first_name = :name or t.fullname.last_name = :name or t.fullname.middle_name = :name", name);
        return user.map(user1 -> new Response<>(new Data<>(userMapper.fromDomaintoVO(user1)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " user not found by name",
                " user not found by name",
                404
        ))));

    }

    @Override
    public Response<Data<List<UserVO>>> findAll() {
        Optional<List<User>> list = userDao.findAll("select t from Subject t");
        return list.map(userlist -> new Response<>(new Data<>(userMapper.fromDomainListtoVOList(userlist)))).orElseGet(() -> new Response<>(new Data<>(new Data.ErrorVO(
                " subjects not found",
                " subjects not found",
                404
        ))));
    }
}
