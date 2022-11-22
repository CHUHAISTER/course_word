package com.nulp.course_work.constants;

import com.nulp.course_work.inputoutput.InputControl;

import java.util.Objects;

import static com.nulp.course_work.inputoutput.output.*;


public enum accessorytype {

    JEWELRY(1, "Jewelry"),

    RIBBON (2, "Ribbon"),

    BEAR (3, "Bear"),

    GELBALL(4, "Gel ball"),

    POSTCARD(5, "Postcard"),

    HEART(6, "Heart");

    private final int numType;

    private final String name;

    accessorytype(int numType, String name) {
        this.numType = numType;
        this.name = name;
    }

    public static void printaccessorytype(){
        printBanner("Types of accessories");
        for(accessorytype type : accessorytype.values()){
            System.out.println(type.numType + "." + type.name);
        }
    }

    public static accessorytype getaccessorytype(int indx){
        for(accessorytype type : accessorytype.values()){
            if(type.numType == indx){
                return type;
            }
        }
        printError("You type a wrong num! Try again");
        return null;
    }

    public static accessorytype getaccessorytype(String indx){
        for(accessorytype type : accessorytype.values()){
            if(Objects.equals(type.name, indx)){
                return type;
            }
        }
        return null;
    }
    public static accessorytype getaccessorytype(){
        printaccessorytype();
        printInfoEntering("Choose type of accessory:");
        int numType = InputControl.enterCorrectInt();

        for(accessorytype type : accessorytype.values()){
            if(type.numType == numType){
                return type;
            }
        }

        printError("You type a wrong num! Try again");
        return getaccessorytype();

    }

    public int getNumType() {
        return numType;
    }

}
