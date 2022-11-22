package com.nulp.course_work.items;

import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.constants.flowertype;
import com.nulp.course_work.inputoutput.InputControl;

import java.util.Objects;

import static com.nulp.course_work.constants.accessorytype.printaccessorytype;
import static com.nulp.course_work.inputoutput.output.*;

public class accessory {
    private int id;         // the id of accessory in database
    private accessorytype Accessorytype;  // the type of accessory
    private String colour;
    private double price;
    private String info;

    private static final int maxSizeOfInformation = 250;

    private static final int maxSizeOfColour = 70;

    public accessory() {}

    public accessory(accessorytype type, String colour, double price, String info){
        this.colour = colour;
        this.Accessorytype = type;
        this.info = info;
        this.price = price;
    }
    public static accessorybuilder builder(){
        return new accessorybuilder();
    }

    public int getId() {
        return id;
    }

    public accessorytype getaccessorytype() {
        return Accessorytype;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "accessory{" +
                "id=" + id +
                ", accessorytype=" + Accessorytype +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        accessory accessory = (accessory) o;
        return id == accessory.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class accessorybuilder{
        private accessory accessory;

        public accessorybuilder(){
            accessory = new accessory();
        }
        public accessorybuilder setId(int id) {
            accessory.id = id;
            return this;
        }

        public accessorybuilder setaccessorytype(accessorytype accessorytype) {
            accessory.Accessorytype =  accessorytype;
            return this;
        }

        public accessorybuilder setColour(String colour) {
            accessory.colour = colour;
            return this;
        }

        public accessorybuilder setPrice(double price) {
            accessory.price = price;
            return this;
        }

        public accessorybuilder setInfo(String info) {
            accessory.info = info;
            return this;
        }

        public accessorybuilder setaccessorytype() {
            printInfoEntering("Choose the type of accessory");
            printaccessorytype();
            accessory.Accessorytype = accessorytype.getaccessorytype();
            return this;
        }

        public accessorybuilder setColour() {
            printInfoEntering("Type the colour of accessory (max symbols " + maxSizeOfColour + "): ");
            accessory.colour = InputControl.enterStringLessThen(maxSizeOfColour);
            return this;
        }

        public accessorybuilder setPrice() {
            printInfoEntering("Type the price of accessory: ");
            accessory.price = InputControl.enterCorrectDouble();
            return this;
        }

        public accessorybuilder setInfo() {
            printInfoEntering("Type the info about accessory (max symbols " + maxSizeOfInformation + "): ");
            accessory.info = InputControl.enterStringLessThen(maxSizeOfInformation);
            return this;
        }

        public accessory built(){
            return accessory;
        }
    }
}
