package com.nulp.course_work;

import com.nulp.course_work.items.accessory;
import com.nulp.course_work.items.flower;
import com.nulp.course_work.itemwithDB.AccessoryDB;
import com.nulp.course_work.itemwithDB.flowerDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.ArrayList;
import java.util.Objects;

import static com.nulp.course_work.inputoutput.InputControl.enterCorrectIndexAccessory;
import static com.nulp.course_work.inputoutput.InputControl.enterCorrectIndexflowers;
import static com.nulp.course_work.inputoutput.output.printBanner;
import static com.nulp.course_work.inputoutput.output.printList;
import static com.nulp.course_work.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;
import static com.nulp.course_work.sortfilter.FilterflowersWithEntering.filteredflowers;


public class Bouquet {
    public static final Logger LOGI = (Logger) LogManager.getLogger(Bouquet.class);


    // The flowers in bouquet
    public static ArrayList<flower> bouquetflowers = new ArrayList<>();
    // The accessories in bouquet
    public static ArrayList<accessory> bouquetAccessories = new ArrayList<>();

    /**
     * A method that displays all the information about the bouquet
     * (flowers in the bouquet, accessories in the bouquet,
     * the average length of the stems, the price of the bouquet)
     */
    public static void printBouquetInfo(){
        printBouquetflowers();
        printBouquetAccessories();
        printBanner("The price of bouquet: " + priceOfBouquet());
        printBanner("The average length flower in bouquet: " + averageLengthOfflowers());
        LOGI.info("All info about bouquet.");
    }

    /**
     * A method that prints flowers in a bouquet
     */
    public static void printBouquetflowers(){
        LOGI.info("All info about bouquet`s flowers.");
        printList(bouquetflowers, "flowers in bouquet");
    }

    /**
     * A method that prints accessories in a bouquet
     */
    public static void printBouquetAccessories(){

        LOGI.info("All info about bouquet`s accessories.");
        printList(bouquetAccessories, "Accessories in bouquet:");
    }

    /**
     * Method that calculates the price of a bouquet
     * @return The price of bouquet
     */
    public static double priceOfBouquet(){
        double price = 0.0;
        for(flower flower : bouquetflowers) price += flower.getPrice();
        for(accessory accessory : bouquetAccessories) price += accessory.getPrice();
        LOGI.info("Price bouquet = " + price);
        return price;
    }

    /**
     * Method that calculates the average length of stems of a bouquet
     * @return The average length of bouquet
     */
    public static double averageLengthOfflowers(){
        double length = 0.0;
        for(flower flower : bouquetflowers) length += flower.getPrice();
        LOGI.info("Average length of flowers in bouquet = " + length / bouquetflowers.size());
        return length / bouquetflowers.size();
    }

    /**
     * A method that adds an accessory to the bouquet.
     * The method asks the user to enter the index of the accessory from the filtering list.
     * if there is such an index - add the accessory to the bouquet
     * and null the value of this accessory in the filtering list
     */

    public static void addAccessoryFromFilteredList(){
        accessory accessory = enterCorrectIndexAccessory(filteredAccessories);
        if(accessory != null){
            bouquetAccessories.add(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
        if(filteredAccessories.stream().allMatch(Objects::isNull)){
            filteredAccessories.clear();
        }
        LOGI.info("Add accessories to bouquet.");
    }

    /**
     * A method that adds an accessory to the bouquet.
     * The method asks the user to enter the index of the accessory from the filtering list.
     * if there is such an index - add the accessory to the bouquet
     * and null the value of this accessory in the filtering list
     */

    public static void addAccessoryFromFilteredListFX(int index){
        accessory accessory = filteredAccessories.get(index);
        if(accessory != null){
            bouquetAccessories.add(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
        if(filteredAccessories.stream().allMatch(Objects::isNull)){
            filteredAccessories.clear();
        }
        LOGI.info("Add accessories to bouquet.");
    }
    /**
     * A method that adds a flower to the bouquet.
     * The method asks the user to enter the index of the flower from the filtering list.
     * if there is such an index - add the flower to the bouquet
     * and null the value of this flower in the filtering list
     */
    public static void addflowerFromFilteredList(){
        flower flower = enterCorrectIndexflowers(filteredflowers);
        if(flower != null){
            Bouquet.bouquetflowers.add(flower);
            filteredflowers.set(filteredflowers.indexOf(flower), null);
        }
        if(filteredflowers.stream().allMatch(Objects::isNull)){
            filteredflowers.clear();
        }
        LOGI.info("Add flowers to bouquet.");

    }


    /**
     * A method that adds a flower to the bouquet.
     * The method asks the user to enter the index of the flower from the filtering list.
     * if there is such an index - add the flower to the bouquet
     * and null the value of this flower in the filtering list
     */
    public static void addflowerFromFilteredListFX(int index){
        flower flower = filteredflowers.get(index);
        if(flower != null){
            Bouquet.bouquetflowers.add(flower);
            filteredflowers.set(filteredflowers.indexOf(flower), null);
        }
        if(filteredflowers.stream().allMatch(Objects::isNull)){
            filteredflowers.clear();
        }
        LOGI.info("Add flowers to bouquet.");

    }
    /**
     * A method that deletes a flower from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet flowers list.
     * if there is such an index - null the value of this flower in the bouquet flowers list
     */

    public static void deleteflowerFromBouq(){
        flower flower = enterCorrectIndexflowers(bouquetflowers);
        if(flower != null){
            bouquetflowers.set(bouquetflowers.indexOf(flower), null);
        }

        if(bouquetflowers.stream().allMatch(Objects::isNull)){
            bouquetflowers.clear();
        }
        LOGI.info("Delete flowers to bouquet.");

    }

    /**
     * A method that deletes a flower from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet flowers list.
     * if there is such an index - null the value of this flower in the bouquet flowers list
     */

    public static void deleteflowerFromBouqFX(int index){
        flower flower = bouquetflowers.get(index);
        if(flower != null){
            bouquetflowers.remove(flower);
        }

        LOGI.info("Delete flowers to bouquet.");

    }
    /**
     * A method that deletes an accessory from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet accessories list.
     * if there is such an index - null the value of this flower in the bouquet accessories list
     */
    public static void deleteAccessoryFromBouq(){

        accessory accessory = enterCorrectIndexAccessory(bouquetAccessories);
        if(accessory != null){
            bouquetAccessories.set(bouquetAccessories.indexOf(accessory), null);
        }

        if(bouquetAccessories.stream().allMatch(Objects::isNull)){
            bouquetAccessories.clear();
        }
        LOGI.info("Delete accessories to bouquet.");

    }


    /**
     * A method that deletes an accessory from the bouquet.
     * The method asks the user to enter the index of the flower from the bouquet accessories list.
     * if there is such an index - null the value of this flower in the bouquet accessories list
     */
    public static void deleteAccessoryFromBouqFX(int index){

        accessory accessory = bouquetAccessories.get(index);
        if(accessory != null){
            bouquetAccessories.remove(accessory);
        }


        LOGI.info("Delete accessories to bouquet.");

    }
    /**
     * Method buy a bouquet
     * All flowers and accessories that are in the bouquet are removed from the database
     */
    public static void buyBouquetDAO(){
        printBouquetInfo();
        AccessoryDB aDao = new AccessoryDB();
        aDao.deleteAllFromBouquet();
        flowerDB fDao = new flowerDB();
        fDao.deleteAllFromBouquet();
        LOGI.info("BUY bouquet!!!");

    }

    /**
     * A method that updates the bouquet when the user exits the bouquet creation menu
     * (removes all flowers and accessories from it)
     */
    public static void refreshBouquet(){
        bouquetflowers.clear();
        bouquetAccessories.clear();
    }
}
