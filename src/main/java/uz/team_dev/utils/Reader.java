package uz.team_dev.utils;

import java.util.Scanner;

public class Reader {
    public static String readLine(){
        return new Scanner(System.in).nextLine();
    }

    public static String readLine (String text, String color){
        System.out.println(color + text);
        return readLine();
    }


    public static String readLine(String text){
        System.out.println(text);
        return readLine();
    }



    public static Long readLong(){
        return new Scanner(System.in).nextLong();
    }

    public static Integer readInt(){
        return new Scanner(System.in).nextInt();
    }


    public static Long readLong(String text){
        System.out.println(text);
        return readLong();
    }

    public static Long readLong(String text, String color){
        System.out.println(color + text + Color.RESET);
        return readLong();
    }

    public static Integer readInt(String text){
        System.out.println(text);
        return readInt();
    }

    public static Integer readInt(String text, String color){
        System.out.println(color + text + Color.RESET);
        return readInt();
    }
}
