package uz.team_dev.ui;

import uz.team_dev.utils.Reader;
import uz.team_dev.utils.Writer;

public class Main {

    public static void main(String[] args) {

        Writer.println("Quiz App");

        Writer.println(" Sign in -> 1");
        Writer.println(" Sign up -> 2");

        switch (Reader.readInt(" => ")){
            case 1 -> signIn();
            case 2 -> singUp();
        }

    }

    private static void singUp() {

    }

    private static void signIn() {

    }


}
