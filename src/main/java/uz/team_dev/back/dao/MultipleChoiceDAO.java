package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.MultipleChoice;

import java.util.List;
import java.util.Optional;

public class MultipleChoiceDAO implements GenericDAO<MultipleChoice>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }


    @Override
    public Optional<List<MultipleChoice>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> persist(MultipleChoice entity) {
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
    public MultipleChoice find(Long id) {
        return null;
    }
}
