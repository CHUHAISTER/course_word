package com.nulp.course_work.inputoutput;

import com.nulp.course_work.items.accessory;
import com.nulp.course_work.items.flower;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.nulp.course_work.inputoutput.output.*;

public class InputControl {
    /**
     * Checks that input is an integer number
     * @return The integer number
     */
    public static int enterCorrectInt() {
        int num;
        try {
            Scanner input = new Scanner(System.in);
            num = input.nextInt();

        } catch (InputMismatchException e) {
            // if value is letter
            printError("You must input an integer! Type again!");
            return InputControl.enterCorrectInt();
        }
        return num;
    }

    public static double enterCorrectDouble() {
        double num;
        try {
            Scanner input = new Scanner(System.in);
            num = input.nextDouble();
            if(num < 0){
                printError("Enter the num that bigger than 0! Type again!");
                return InputControl.enterCorrectDouble();
            }

        } catch (InputMismatchException e) {
            // if value is letter
            printError("You must input a double!");
            return InputControl.enterCorrectDouble();
        }
        return num;
    }

    public static String enterStringLessThen(int numOfSymbols){
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        if(text.length() > numOfSymbols){
            printError("It`s too long! Make sure that you type less then " + numOfSymbols
                    + " and try again! ");
            return enterStringLessThen(numOfSymbols);
        }
        return text;
    }

    public static Double enterDoubleInRange(Double min, Double max){
        double num;
        try {
            Scanner input = new Scanner(System.in);
            num = input.nextDouble();
            // if the value not in interval
            if(num > max || num < min){
                printError("You must type a number in interval [" + min + ", " + max + "] Type again!");
                return enterDoubleInRange(min, max);
            }

        } catch (InputMismatchException e) {
            // if value is letter
            printError("You must input a double in range!");
            return enterDoubleInRange(min, max);
        }
        return num;
    }

    public static Double enterDoubleInRangeAndBiggerThan(Double min, Double max, Double enteredMin){
        double num;
        try {
            Scanner input = new Scanner(System.in);
            num = input.nextDouble();
            // if the value not in interval
            if(num > max || num < min || num < enteredMin){
                printError("You must type a number in interval [" + min + ", " + max + "] and " +
                        "bigger than " + enteredMin + " Try again!");
                return enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
            }

        } catch (InputMismatchException e) {
            // if value is letter
            printError("You must input a double in range!");
            return enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
        }
        return num;
    }

    public static accessory enterCorrectIndexAccessory(ArrayList<accessory> accessories){
        printInfoEntering("Type the correct index of accessory:");
        int num = enterCorrectInt();

        if(num < 0 || num > accessories.size()){
            printError("There is no such index! It`s too big or small. Look at the list");
            return null;
        }
        if(accessories.get(num) == null){
            printError("Maybe you have entered this index. Look again!");
            return null;
        }

        return accessories.get(num);
    }
    public static flower enterCorrectIndexflowers(ArrayList<flower> flowers){
        printInfoEntering("Type the correct index of flower:");
        int num = enterCorrectInt();

        if(num < 0 || num > flowers.size()){
            printError("There is no such index! It`s too big or small. Look at the list");
            return null;
        }
        if(flowers.get(num) == null){
            printError("Maybe you have entered this index. Look again!");
            return null;
        }

        return flowers.get(num);
    }
}
