package uz.team_dev.front.ui;

import uz.team_dev.back.enums.Level;
import uz.team_dev.back.mapper.UserMapper;
import uz.team_dev.back.service.MultipleChoiceService;
import uz.team_dev.back.service.QuizService;
import uz.team_dev.back.service.SubjectService;
import uz.team_dev.back.service.UserService;
import uz.team_dev.back.vo.auth.questions.MultipleChoiceCVO;
import uz.team_dev.back.vo.auth.quiz.QuizCVO;
import uz.team_dev.back.vo.auth.quiz.QuizUVO;
import uz.team_dev.back.vo.auth.quiz.QuizVO;
import uz.team_dev.back.vo.auth.subject.SubjectCVO;
import uz.team_dev.back.vo.auth.subject.SubjectUVO;
import uz.team_dev.back.vo.auth.subject.SubjectVO;
import uz.team_dev.back.vo.auth.user.UserVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.utils.Reader;
import uz.team_dev.back.vo.utils.Util;
import uz.team_dev.back.vo.utils.Writer;

import java.util.List;
import java.util.Scanner;

public class TeacherPage {

    private static final UserMapper userMapper = UserMapper.getInstance();
    private static final SubjectService subjectService = SubjectService.getInstance();
    private static final UserService userService = UserService.getInstance();
    private static final QuizService quizService = QuizService.getInstance();

    private static final Scanner intscanner = new Scanner(System.in);

    public static void menu() {

        Writer.printlnMiddle(" === TEACHER PAGE ===");
        Writer.printlnMiddle(" 1 => Subject CRUD");
        Writer.printlnMiddle(" 2 => Quiz CRUD");
        Writer.printlnMiddle(" 3 => My profile");
        Writer.printlnMiddle(" 0 => Back");

        switch (Reader.readIntMiddle(" => ")) {
            case 1 -> subjectCRUD();
            case 2 -> quizCRUD();
            case 3 -> myProfile();
            case 0 -> {
                return;
            }
            default -> menu();
        }
        menu();
    }

    private static void myProfile() {

    }

    private static void quizCRUD() {

        Writer.printlnMiddle(" ===  QUIZ CRUD  === ");

        Writer.printlnMiddle(" 1 -> Create QUIZ ");
        Writer.printlnMiddle(" 2 -> Edit QUIZ ");
        Writer.printlnMiddle(" 3 -> Show QUIZ ");
        Writer.printlnMiddle(" 4 -> Show All QUIZs");
        Writer.printlnMiddle(" 5 -> Delete QUIZ ");
        Writer.printlnMiddle(" 0 -> Back ");

        switch (Reader.readIntMiddle(" => ")) {
            case 1 -> createQUIZ();
            case 2 -> editQUIZ();
            case 3 -> showQUIZ();
            case 4 -> showAllQUIZ();
            case 5 -> deleteQUIZ();
            case 0 -> {
                return;
            }
            default -> quizCRUD();
        }
        quizCRUD();
    }

    private static void deleteQUIZ() {
        Writer.printlnMiddle(" ===  CREATE QUIZ  === ");

        Writer.printlnMiddle(" Enter id of quiz ");

//        Data<Boolean> data = quizService.delete(id).getData();
//        if (data.isSuccess()){
//            Writer.printlnMiddle(" Quiz deleted");
//        }
//        else
//            Writer.printlnMiddleERR("Quiz can not deleted");
//
//        Reader.readLineMiddle(" Press any key to back");

    }

    private static void showAllQUIZ() {
        Writer.printlnMiddle(" ===  SHOW ALL QUIZZES  === ");

        Data<List<QuizVO>> data = quizService.findAll().getData();
        if (data.isSuccess()){
            for (QuizVO quizVO : data.getBody()) {
                System.out.println(quizVO);
            }
        }

        Reader.readLineMiddle("Press any key to back");

    }

    private static void showQUIZ() {
        Writer.printlnMiddle(" ===  SHOW QUIZ  === ");



        Writer.printlnMiddle(" Enter id of quiz ");

        long id = intscanner.nextLong();

        Data<QuizVO> data = quizService.find(id).getData();

        System.out.println(data.getBody());

        Reader.readLineMiddle(" Press any key to back");


    }

    private static void editQUIZ() {
        Writer.printlnMiddle(" ===  EDIT QUIZ  === ");

        Writer.printlnMiddle(" Enter quiz id: ");

        long id = intscanner.nextLong();

        String name = Reader.readLineMiddle("Enter new name: ");

        String desc = Reader.readLineMiddle("Enter new description: ");

        QuizUVO quizUVO = QuizUVO.builder()
                .id(id)
                .name(name)
                .level(Util.levelChoosing())
                .subject_id(Util.subjectChoosing())
                .build();

        Data<Boolean> update = quizService.update(quizUVO).getData();

        if (update.isSuccess()) {

            Writer.printlnMiddle("Quiz updated");

        } else {

            Writer.printlnMiddle(update.getError().getFriendlyMessage());

        }

        Reader.readLineMiddle(" Press any key to back");

    }

    private static void createQUIZ() {
        Writer.printlnMiddle(" ===  CREATE QUIZ  === ");

        QuizCVO quizCVO = QuizCVO.builder()
                .subject_id(Util.subjectChoosing())
                .level(Util.levelChoosing())
                .created_by(UserSession.getSession().getUserVO().getId())
                .name(Reader.readLineMiddle(" Enter name of quiz => "))
                .build();

        Data<Long> data = quizService.persist(quizCVO).getData();

        if (data.isSuccess()) {
            Long quiz_id = data.getBody();

            Writer.printMiddle("How many questions does your quiz have => ");

            int count = intscanner.nextInt();
            QuestionPage.questionsCreate(count,quiz_id);

            Writer.printlnMiddle("Questions successfully created");

        } else {

            Writer.printlnMiddleERR(data.getError().getFriendlyMessage());

        }

        Writer.printlnMiddle("Quiz successfully created");
        Reader.readLineMiddle("Press any key to back");

    }



    private static void subjectCRUD() {

        Writer.printlnMiddle(" ===  SUBJECT CRUD  === ");

        Writer.printlnMiddle(" 1 -> Create Subject ");
        Writer.printlnMiddle(" 2 -> Edit Subject ");
        Writer.printlnMiddle(" 3 -> Show Subject ");
        Writer.printlnMiddle(" 4 -> Show All Subjects");
        Writer.printlnMiddle(" 5 -> Delete Subject ");
        Writer.printlnMiddle(" 0 -> Back ");

        switch (Reader.readIntMiddle(" => ")) {
            case 1 -> createSubject();
            case 2 -> editSubject();
            case 3 -> showSubject();
            case 4 -> showAllSubject();
            case 5 -> deleteSubject();
            case 0 -> {
                return;
            }
            default -> subjectCRUD();
        }
        subjectCRUD();
    }

    private static void deleteSubject() {

        Writer.printlnMiddle(" ===  delete SUBJECT  === ");

        Writer.printlnMiddle(" Enter subject id: ");

        long id = intscanner.nextLong();

        Data<Boolean> data = subjectService.delete(id).getData();

        if (data.isSuccess()) {
            Writer.printlnMiddle("Subject is deleted");
        } else {
            Writer.printlnMiddle(data.getError().getFriendlyMessage());
        }

        Writer.printlnMiddle("Press any key to back");

    }

    private static void showAllSubject() {

        Data<List<SubjectVO>> data = subjectService.findAll().getData();

        if (data.isSuccess()) {
            System.out.println(data.getBody());
        } else {
            System.out.println(data.getError().getFriendlyMessage());
        }

        Reader.readLineMiddle(" Press any key to back");


    }

    private static void showSubject() {

        Writer.printlnMiddle(" === Show SUBJECT === ");

        Data<UserVO> data;

        switch (Reader.readIntMiddle("Find by name(1), Find by id(2) =>  ")) {
            case 1 -> {

                String name = Reader.readLineMiddle(" Enter name of subject ");

                data = userService.find(name).getData();

                System.out.println(data.getBody());

            }
            case 2 -> {

                Writer.printlnMiddle(" Enter id of subject ");

                long id = intscanner.nextLong();

                Data<UserVO> data1 = userService.find(id).getData();

                System.out.println(data1.getBody());

            }

            case 0 -> {
                return;
            }

            default -> showSubject();
        }

        Reader.readLineMiddle(" Press any key to back");


    }

    private static void editSubject() {

        Writer.printlnMiddle(" === Edit SUBJECT === ");

        Writer.printlnMiddle(" Enter subject id: ");

        long id = intscanner.nextLong();

        String name = Reader.readLineMiddle("Enter new name: ");

        String desc = Reader.readLineMiddle("Enter new description: ");

        SubjectUVO subjectUVO = SubjectUVO.builder()
                .id(id)
                .name(name)
                .description(desc)
                .build();

        Data<Boolean> update = subjectService.update(subjectUVO).getData();

        if (update.isSuccess()) {

            Writer.printlnMiddle("Subject updated");

        } else {

            Writer.printlnMiddle(update.getError().getFriendlyMessage());

        }

        Reader.readLineMiddle(" Press any key to back");

    }

    private static void createSubject() {

        Writer.printlnMiddle(" === Create SUBJECT === ");

        String name = Reader.readLineMiddle(" Enter name of subject ");
        String desc = Reader.readLineMiddle(" Enter description of subject ");


        SubjectCVO subject = SubjectCVO.builder()
                .name(name)
                .description(desc)
                .created_by(UserSession.getSession().getUserVO().getId())
                .build();
        subjectService.persist(subject);

        Reader.readLineMiddle(" Press any key to back");

    }
}
