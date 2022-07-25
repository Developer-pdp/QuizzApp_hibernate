package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.Match;

import java.util.List;
import java.util.Optional;

public class MatchDAO extends GenericDAO<Match>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

}
