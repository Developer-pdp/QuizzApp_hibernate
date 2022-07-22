package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;

import java.util.List;
import java.util.Optional;

public class AnswerDAO implements GenericDAO<MultipleChoiceAnswer>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    @Override
    public Optional<List<MultipleChoiceAnswer>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> persist(MultipleChoiceAnswer entity) {
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
    public MultipleChoiceAnswer find(Long id) {
        return null;
    }
}
