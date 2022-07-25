package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.FillingBlank;


public class FillingBlankDAO extends   GenericDAO<FillingBlank>{

    private static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null) instance = new UserDao();
        return instance;
    }

}
