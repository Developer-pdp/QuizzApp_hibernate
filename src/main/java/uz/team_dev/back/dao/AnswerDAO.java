package uz.team_dev.back.dao;

import uz.team_dev.back.domains.questions.MultipleChoiceAnswer;

public class AnswerDAO extends GenericDAO<MultipleChoiceAnswer> {

    private static AnswerDAO instance;

    public static AnswerDAO getInstance() {
        if (instance == null) instance = new AnswerDAO();
        return instance;
    }
}
