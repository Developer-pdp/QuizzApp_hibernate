package uz.team_dev.back.vo.utils;

import uz.team_dev.back.enums.Level;
import uz.team_dev.back.service.SubjectService;
import uz.team_dev.back.vo.auth.subject.SubjectVO;
import uz.team_dev.back.vo.response.Data;

import java.util.List;

public class Util {

    private static final SubjectService subjectService = SubjectService.getInstance();

    public static Level levelChoosing() {
        Writer.printlnMiddle(" Choose subject ");
        Writer.printlnMiddle(Level.EASY.name());
        Writer.printlnMiddle(Level.MEDIUM.name());
        Writer.printlnMiddle(Level.HARD.name());
        return switch (Reader.readIntMiddle(" => ")){
            case 2 -> Level.MEDIUM;
            case 3 ->  Level.HARD;
            default ->  Level.EASY;
        };
    }

    public static Long subjectChoosing(){
        Data<List<SubjectVO>> data = subjectService.findAll().getData();
        if (data.isSuccess()){
            int k = 1;
            for (SubjectVO subjectVO : data.getBody()) {
                Writer.printlnMiddle(k++ + ") " + subjectVO.getName());
            }
        }
        List<SubjectVO> body = data.getBody();
        int i = Reader.readIntMiddle("Choose a subject => ");
        return body.get(i-1).getId();
    }

}
