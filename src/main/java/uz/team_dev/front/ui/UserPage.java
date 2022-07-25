package uz.team_dev.front.ui;

import uz.team_dev.back.enums.Role;

public class UserPage {
    public static void menu() {
        if (UserSession.getSession().getUserVO().getRole() == Role.TEACHER) {
            TeacherPage.menu();
        } else StudentPage.menu();
    }
}
