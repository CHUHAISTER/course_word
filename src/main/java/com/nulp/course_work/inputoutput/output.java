package com.nulp.course_work.inputoutput;

import java.util.ArrayList;

public class output {
    public static String simpleline = "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    public static String enterline = "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";


    public static void printInfoEntering(String info){
        System.out.println(simpleline);
        System.out.println(info);
    }

    public static void printBanner(String info){
        System.out.println(enterline);
        System.out.println(info);
        System.out.println(simpleline);
    }

    public static void printError(String error){
        System.out.println(simpleline);
        System.out.println("\uD83D\uDC94 " + error);
        System.out.println(simpleline);
    }

    public static <T> void printList(ArrayList<T> arrayList, String info){
        printBanner(info);
        if(arrayList.isEmpty()){
            System.out.println("\nNothing was found =(");
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) != null){
                System.out.println(i + ". " + arrayList.get(i));
            }
        }
    }
}
