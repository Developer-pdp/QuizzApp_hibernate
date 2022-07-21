package uz.team_dev.back.domains.quiz;

import jakarta.persistence.GeneratedValue;
 import uz.team_dev.back.dao.GenericDAO;
import uz.team_dev.back.dao.UserDao;
import uz.team_dev.back.domains.Domain;

import java.util.List;

/**
 * name : Abul_dev
 * date : 21, Thursday, 2022
 * project name : QuizzApp_hibernate
 */
public class QuizDAO implements GenericDAO {

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Long persist(Domain entity) {
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
    public Domain find(Long id) {
        return null;
    }
}
