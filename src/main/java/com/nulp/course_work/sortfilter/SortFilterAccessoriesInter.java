package com.nulp.course_work.sortfilter;

import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.items.accessory;

import java.util.List;

public interface SortFilterAccessoriesInter {

    /**
     * The method that returns all accessories
     * @return The list of all accessories
     */
    List<accessory> getAll();

    /**
     * The method that searches for accessories in a price range
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of accessories in the price range
     */
    List<accessory> filterInPriceRange(Double min, Double max);

    /**
     * The method that searches for accessories of a given type
     * @param accessoryType The accessory type
     * @return The list of accessories of a given type
     */
    List<accessory> sortByType(accessorytype accessoryType);

    /**
     * The method that looks for the maximum price of an accessory
     * @return The maximum price of an accessory
     */
    Double minPrice();

    /**
     * The method that looks for the minimum price of an accessory
     * @return The minimum price of an accessory
     */
    Double maxPrice();
}
