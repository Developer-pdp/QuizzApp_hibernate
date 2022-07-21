package uz.team_dev.back.dao;

import com.google.gson.Gson;
import uz.team_dev.back.domains.Domain;

import java.util.List;

public interface GenericDAO<T extends Domain> {

    Gson gson = new Gson();


     List<T> getAll();

    Long persist(T entity);

    boolean delete(Long id);

    boolean update(Long id);

    T find(Long id);

}
