package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.FillingBlank;

import java.util.List;
import java.util.Optional;

public class FillingBlankDAO implements  GenericDAO<FillingBlank>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

    @Override
    public Optional<List<FillingBlank>> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Long> persist(FillingBlank entity) {
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
    public FillingBlank find(Long id) {
        return null;
    }
}
