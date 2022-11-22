package com.nulp.course_work.constants;

import com.nulp.course_work.inputoutput.InputControl;

import java.util.Objects;

import static java.lang.Boolean.TRUE;
import static com.nulp.course_work.inputoutput.output.*;


public enum ordersort {
    DESC (1, "In descending order"),

    ASC (2, "In ascending order" );

    private final int numType;
    private final String name;

    ordersort(int type, String name) {
        this.numType = type;
        this.name = name;
    }

    public static void printordersortType(){
        printBanner("Types of order");
        for(ordersort type : ordersort.values()){
            System.out.println(type.numType + ". " + type.name);
        }
    }

    public static ordersort getordersortype(int indx){
        for(ordersort type : ordersort.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    public static ordersort getordersortype(String indx){
        for(ordersort type : ordersort.values()){
            if(Objects.equals(type.name, indx)){
                return type;
            }
        }
        return null;
    }

    public static ordersort getordersorttype(){
        printordersortType();
        printInfoEntering("Choose the order type:");
        int numType = InputControl.enterCorrectInt();
        while (TRUE) {
            for (ordersort type : ordersort.values()) {
                if (type.numType == numType) {
                    return type;
                }
            }
            printError("You type a wrong num! Try again");
        }
        return null;
    }
}
