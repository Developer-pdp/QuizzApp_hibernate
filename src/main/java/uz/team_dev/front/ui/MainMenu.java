package uz.team_dev.front.ui;


import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Language;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.vo.utils.Reader;
import uz.team_dev.back.vo.utils.Writer;



public class MainMenu {
    public static void main(String[] args) {

        Writer.println("Quiz App");

        Writer.println("Sign in -> 1");
        Writer.println("Sign up -> 2");

        switch (Reader.readIntMiddle(" => ")) {
            case 1 -> signin();
            case 2 -> signup();
            default -> main(args);
        }

    }

    private static void signup() {

        User user = User.builder()
                .fullname(new Fullname("","",""))
                .login(new Login("",""))
                .language(Language.EN)
                .role(Role.ADMIN)
                .build();

        Reader.readLine("Enter your name: ");

    }

    private static void signin() {


    }
}
