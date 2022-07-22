package uz.team_dev.front.ui;


import uz.team_dev.back.domains.user.Fullname;
import uz.team_dev.back.domains.user.Login;
import uz.team_dev.back.domains.user.User;
import uz.team_dev.back.enums.Role;
import uz.team_dev.back.service.UserService;
import uz.team_dev.back.vo.auth.LoginVO;
import uz.team_dev.back.vo.auth.UserVO;
import uz.team_dev.back.vo.response.Data;
import uz.team_dev.back.vo.utils.Color;
import uz.team_dev.back.vo.utils.Reader;
import uz.team_dev.back.vo.utils.Writer;

public class MainMenu {

    private static final UserService userService = UserService.getInstance();

    public static void main(String[] args) {


        Writer.println("Quiz App");

        Writer.printlnMiddle("Sign in -> 1");
        Writer.printlnMiddle("Sign up -> 2");

        switch (Reader.readIntMiddle(" => ")) {
            case 1 -> signin();
            case 2 -> signup();
            default -> main(args);
        }

    }

    private static void signup() {

        String firstname = Reader.readLineMiddle("Enter your first name: ");
        String middle = Reader.readLineMiddle("Enter your middle name: ");
        String last = Reader.readLineMiddle("Enter your last name: ");
        String username = Reader.readLineMiddle("Enter your username: ");
        String password = Reader.readLineMiddle("Enter your password: ");

        User user = User.builder()
                .fullname(new Fullname(firstname,middle,last))
                .login(new Login(username,password))
                .role(Role.ADMIN)
                .build();

        userService.persist(user);
    }

    private static void signin() {

        String username = Reader.readLineMiddle("Enter your username: ");
        String password = Reader.readLineMiddle("Enter your password: ");

        LoginVO loginVO  = new LoginVO(username,password);

        Data<UserVO> login = userService.login(loginVO).getData();

        if (login.isSuccess()) {
            UserVO body = login.getBody();
            UserSession.getSession().setUserVO(body);

            if (UserSession.getSession().getUserVO().getRole() == Role.ADMIN)
                AdminPage.menu();
            else UserPage.menu();

        } else Writer.println(login.getError().getFriendlyMessage(), Color.RED);

    }
}
