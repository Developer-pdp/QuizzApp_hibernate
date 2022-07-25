package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.MultipleChoice;

import java.util.List;
import java.util.Optional;

public class MultipleChoiceDAO extends GenericDAO<MultipleChoice>{

    private static MultipleChoiceDAO instance;

    public static MultipleChoiceDAO getInstance() {
        if (instance == null) instance = new MultipleChoiceDAO();
        return instance;
    }


}
