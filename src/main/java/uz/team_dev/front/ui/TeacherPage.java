package uz.team_dev.front.ui;

import uz.team_dev.back.vo.utils.Reader;
import uz.team_dev.back.vo.utils.Writer;

public class TeacherPage {

    public static void menu() {

        Writer.printlnMiddle(" === TEACHER PAGE ===");
        Writer.printlnMiddle(" 1 => Subject CRUD");
        Writer.printlnMiddle(" 2 => Quiz CRUD");
        Writer.printlnMiddle(" 3 => My profile");
        Writer.printlnMiddle(" 0 => Back");

        switch (Reader.readIntMiddle(" => ")){
            case 1 -> subjectCRUD();
            case 2 -> quizCRUD();
            case 3 -> myProfile();
            case 0 -> {return;}
            default -> menu();
        }

    }

    private static void myProfile() {

    }

    private static void quizCRUD() {



    }

    private static void subjectCRUD() {

        Writer.printlnMiddle(" ===  SUBJECT CRUD  === ");



    }
}
