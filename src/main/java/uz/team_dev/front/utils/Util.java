package uz.team_dev.front.utils;

public class Util {

    public static void pause(){
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
