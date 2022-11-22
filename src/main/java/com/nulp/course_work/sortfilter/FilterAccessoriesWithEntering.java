package com.nulp.course_work.sortfilter;


import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.inputoutput.InputControl;
import com.nulp.course_work.items.accessory;

import java.util.ArrayList;

import static com.nulp.course_work.Bouquet.bouquetAccessories;
import static com.nulp.course_work.constants.accessorytype.getaccessorytype;
import static com.nulp.course_work.inputoutput.output.*;

public class FilterAccessoriesWithEntering {

    // Static arraylist of current filtering/sorting of accessories
    public static ArrayList<accessory> filteredAccessories = new ArrayList<>();

    /**
     * The method that searches for accessories of a given type that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of accessories of a given type
     */
    public static ArrayList<accessory> filterAccessoriesByType() {
        SortFilterAccessoriesDB sortFilterAccessoriesDB = new SortFilterAccessoriesDB();
        filteredAccessories = sortFilterAccessoriesDB.sortByType(getaccessorytype());
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }

    /**
     * The method that searches for accessories of a given type that not in use FX
     * This method calls for the user to enter the filter parameters
     * @return The list of accessories of a given type
     */
    public static ArrayList<accessory> filterAccessoriesByTypeFX(accessorytype type) {
        SortFilterAccessoriesDB sortFilterAccessoriesDB = new SortFilterAccessoriesDB();
        filteredAccessories = sortFilterAccessoriesDB.sortByType(type);
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }

    /**
     * The method that returns all accessories that not in use
     * This method calls for the user to enter the filter parameters
     * @return The list of all accessories that not used
     */
    public static ArrayList<accessory> filterAllAccessories() {
        SortFilterAccessoriesDB sortFilterAccessoriesDB = new SortFilterAccessoriesDB();
        filteredAccessories = sortFilterAccessoriesDB.getAll();
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }


    /**
     * The method that searches for accessories in a price range
     * The method asks the user to enter the search parameters (minimum and maximum limit)
     * @return The list of accessories in the price range
     */
    public static ArrayList<accessory> filterAccessInPriceRange() {

        SortFilterAccessoriesDB filtrationaccessory = new SortFilterAccessoriesDB();

        double min = filtrationaccessory.minPrice();
        double max = filtrationaccessory.maxPrice();

        printBanner("To filter by price, you must enter in which price range you are looking for accessories." +
                "\nStore accessory price range: min price - " + min + " max price - " + max);

        System.out.println("Type the min for your search in range [" + min + ", " + max + "] : ");
        double enteredMin = InputControl.enterDoubleInRange(min, max);

        printInfoEntering("Type the max for your search in range [" + min + ", " + max + "]" +
                " and bigger than " + enteredMin + ":");

        double enteredMax = InputControl.enterDoubleInRangeAndBiggerThan(min, max, enteredMin);
        filteredAccessories = filtrationaccessory.filterInPriceRange(enteredMin, enteredMax);
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }


    /**
     * The method that searches for accessories in a price range
     * The method asks the user to enter the search parameters (minimum and maximum limit)
     * @return The list of accessories in the price range
     */
    public static ArrayList<accessory> filterAccessInPriceRangeFX(double enteredMin, double enteredMax) {

        SortFilterAccessoriesDB filtrationaccessory = new SortFilterAccessoriesDB();

        double min = filtrationaccessory.minPrice();
        double max = filtrationaccessory.maxPrice();
        filteredAccessories = filtrationaccessory.filterInPriceRange(enteredMin, enteredMax);
        filteredAccessories.removeAll(bouquetAccessories);
        return filteredAccessories;
    }
    public static void printFilteredAccessories() {
        printList(filteredAccessories, "accessory search result:");
    }
}
