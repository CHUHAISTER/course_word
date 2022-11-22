package com.nulp.course_work.constants;

import com.nulp.course_work.inputoutput.InputControl;

import java.util.Objects;

import static com.nulp.course_work.inputoutput.output.*;


public enum flowertype {
    ROSE(1, "Rose"),

    LAVANDULA(2, "Lavandula"),

    LILY(3, "Lily"),

    LUPINE(4, "Lupine"),

    TULIP(5, "Tulip"),

    DAISY(6, "Daisy"),

    GARDENIA(7, "Gardenia"),

    ORCHID(8, "Orchid"),

    GYPSOPHILA(9, "Gypsophila"),

    CHAMOMILE(10, "Chamomile"),

    CHRYSANTHEMUM(11, "Chrysanthemum");

    private final int numType;
    private final String name;

    flowertype(int type, String name) {
        this.numType = type;
        this.name = name;
    }

    public static void printflowertype(){
        printBanner("Types of flowers");
        for(flowertype type : flowertype.values()){
            System.out.println(type.numType + "." + type.name);
        }
    }

    public static flowertype getflowertype(int indx){
        for(flowertype type : flowertype.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    public static flowertype getflowertype(String indx){
        for(flowertype type : flowertype.values()){
            if(Objects.equals(type.name, indx)){
                return type;
            }
        }
        //printError("You type a wrong num! Try again");
        return null;
    }
    public static flowertype getflowertype(){
        printflowertype();
        printInfoEntering("Choose a flower type:");
        int numType = InputControl.enterCorrectInt();

            for (flowertype type : flowertype.values()) {
                if (type.numType == numType) {
                    return type;
                }
            }

            printError("You type a wrong num! Try again");

        return getflowertype();
    }

    public int getNumType() {
        return numType;
    }
}
