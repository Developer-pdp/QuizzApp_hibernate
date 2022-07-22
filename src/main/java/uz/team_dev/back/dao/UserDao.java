package uz.team_dev.back.dao;


import uz.team_dev.back.domains.user.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements GenericDAO<User> {

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }


    @Override
    public Optional<List<User>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> persist(User entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(Long id) {
        return Optional.empty();
    }

    @Override
    public User find(Long id) {
        return null;
    }
}
