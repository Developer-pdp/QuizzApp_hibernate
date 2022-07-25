package uz.team_dev.back.dao;

import com.google.gson.Gson;
import uz.team_dev.back.domains.Domain;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T extends Domain> {

    Gson gson = new Gson();

     Optional<List<T>> getAll();

    Optional<Long> persist(T entity);

    Optional<Boolean> delete(Long id);

    Optional<Boolean> update(T entity);

    Optional<T> find(Long id);

}
