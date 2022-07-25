package uz.team_dev.back.vo.utils;

import java.io.PrintStream;

/**
 * @author "Elmurodov Javohir"
 * @since 14/06/22/15:56 (Tuesday)
 * untitled/IntelliJ IDEA
 */
public class Writer {
    private static final PrintStream out = null;


    public static void print(Object data) {
        print(data, Color.BLUE);
    }

    public static void print(Object data, String color) {
        System.out.print(color + data + Color.RESET);
    }

    public static void println(Object data) {
        println(data, Color.BLUE);
    }

    public static void println(Object data, String color) {
        System.out.println(color + data + Color.RESET);
    }

    public static void printMiddle(String text){
        int mid = (60-text.length())/2;
        for (int i = 0; i < mid; i++) {
            System.out.print(' ');
        }
        Writer.print(text);
        for (int i = 0; i < mid; i++) {
            System.out.print(' ');
        }
    }

    public static void printMiddle(String text, int space, char with, String color){
        int mid = (space-text.length())/2;
        for (int i = 0; i < mid; i++) {
            System.out.print(with);
        }
        Writer.print(text,color);
        for (int i = 0; i < mid; i++) {
            System.out.print(with);
        }
    }

    public static void printlnMiddle(String text, int space, char with, String color){
        printMiddle(text,space,with,color);
        Writer.println("");
    }

    public static void printlnMiddles(int space, char with, String color, String... texts){
        for (String text : texts) {
            printlnMiddle(text,space,with,color);
        }
    }

    public static void printlnMiddle(String text){
        printMiddle(text,60,' ', Color.GREEN);
        Writer.println("");
    }

    public static void printlnMiddleERR(String text){
        printMiddle(text,60,' ', Color.RED);
        Writer.println("");
    }

    public static void printRight(String text,String color){
        int mid = 60-text.length();
        for (int i = 0; i < mid; i++) {
            System.out.print(" ");
        }
        Writer.print(text,color);
    }




    public static void printMiddleFixed(String text, int space, char with, String color) {
        int mid = (space - text.length()) / 2;
        for (int i = 0; i < mid; i++) {
            System.out.print(with);
        }
        Writer.print(text, color);

    }

}
