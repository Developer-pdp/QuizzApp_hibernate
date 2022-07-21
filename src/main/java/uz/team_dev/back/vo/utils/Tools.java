package uz.team_dev.back.vo.utils;

import config.ApplicationContextHolder;
import domains.Subject;
import domains.User;
import enums.Language;
import enums.Level;
import service.SubjectService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Team <Developers>
 * @project Trello
 * @since 17/06/22   18:28   (Friday)
 */
public class Tools {

    private static SubjectService subjectService = ApplicationContextHolder.getBean(SubjectService.class);


    public static void clear(){
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static boolean isUnique(String username) {
        for (User user : UserService.getInstance().findAll()) {
            if (user.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }

    public static void proInfo(String orgName){
        Writer.printlnRight("org: "+orgName, 80, ' ', Color.PURPLE);
        Writer.println("");
    }

    public static void proInfo(String orgName, String proName){
        Writer.printlnRight("org: "+orgName, 80, ' ', Color.PURPLE);
        Writer.printlnRight("pro: "+proName, 80, ' ', Color.PURPLE);
        Writer.println("");
    }

    public static void userInfo(String username){
        Writer.printlnRight("user: "+username, 60, ' ', Color.PURPLE);
        Writer.println("");
    }

    public static void userInfo(String username, String role){
        Writer.printlnRight("user: "+username+" (" + role + ")", 80, ' ', Color.PURPLE);
        Writer.println("");
    }
    public static Map<Long, AtomicLong> increments = new HashMap<>();

    public static Long getId(Long id) {
        if (increments.get(id)==null){
            increments.put(id, new AtomicLong(1));
        }
        return increments.get(id).getAndIncrement();
    }


    public static Language langChoosing() {

        Writer.printlnMiddles(60, ' ', Color.GREEN,
                "1." + Language.UZ.name(),
                "2." + Language.EN.name(),
                "3." + Language.RU.name());


        int n = Reader.readIntMiddle("Choose language:");
        while (n<1 || n>3){
            n = Reader.readIntMiddle(" Choose language: ");
        }

        Language lang = null;
        switch (n){
            case 1 -> lang = Language.UZ;
            case 2 -> lang = Language.EN;
            case 3 -> lang = Language.RU;
        }
        return lang;
    }

    public static Level levelChoosing() {
        Writer.printlnMiddles(60, ' ', Color.GREEN,
                "1."+ Level.HARD.name(),
                "2."+Level.MEDIUM.name(),
                "3."+Level.EASY.name());

        int n = Reader.readIntMiddle("Choose level:");
        while (n<1 || n>3){
            n = Reader.readIntMiddle(" Choose level: ");
        }

        Level level = null;
        switch (n){
            case 1 -> level = Level.HARD;
            case 2 -> level = Level.MEDIUM;
            case 3 -> level = Level.EASY;
        }
        return level;
    }

    public static Subject subjectChoosing() {
        AtomicInteger or = new AtomicInteger(1);

        List<Subject> all = subjectService.findAll();

        for (Subject subject : all) {
            Writer.printlnMiddle(or.getAndIncrement() + ") " + subject.getName(),80);
        }

        int n = Reader.readIntMiddle("Choose subject:");
        while (n<1 || n>all.size()){
            n = Reader.readIntMiddle(" Choose subject: ");
        }

        return all.get(n-1);

    }
}
