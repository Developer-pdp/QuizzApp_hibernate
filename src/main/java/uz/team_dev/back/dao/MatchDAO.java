package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.Match;

import java.util.List;
import java.util.Optional;

public class MatchDAO implements GenericDAO<Match>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    @Override
    public Optional<List<Match>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> persist(Match entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> update(Match entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Match> find(Long id) {
        return null;
    }
}
