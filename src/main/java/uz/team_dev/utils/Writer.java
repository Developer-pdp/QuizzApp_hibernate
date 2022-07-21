package uz.team_dev.utils;

public class Writer {

    public static void print(Object obj, String color){
        System.out.print(obj + color);
    }
    public static void print(Object obj, String color, String bg){
        System.out.print(obj + bg + color);
    }

    public static void println(Object obj, String color){
        System.out.println(color + obj);
    }
    public static void println(Object obj){
        System.out.println(obj);
    }

    public static void println(){
        System.out.println();
    }
}
