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
    public List<User> getAll() {
        return null;
    }

    @Override
    public Long persist(User entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean update(Long id) {
        return false;
    }

    @Override
    public User find(Long id) {
        return null;
    }



}
