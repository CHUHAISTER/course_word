package com.nulp.course_work.sortfilter;



import com.nulp.course_work.constants.flowertype;
import com.nulp.course_work.constants.ordersort;
import com.nulp.course_work.items.flower;

import java.util.List;

public interface SortFilterflowersInter {

    /**
     * The method that returns all flowers
     * @return The list of all flowers
     */
    List<flower> getAll();

    /**
     * The method that searches for flowers in a price range
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the price range
     */
    List<flower> filterInPriceRange(double min, double max);

    /**
     * The method that searches for flowers in a length range
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the length range
     */
    List<flower> filterInLengthRange(double min, double max);

    /**
     * The method that searches for flowers of a given type
     * @param flowertype The flower type
     * @return The list of flowers of a given type
     */
    List<flower> sortByType(flowertype flowertype);

    /**
     * The method that sorts all flowers in ascending or descending order of freshness
     * @param ordersort Sorting type (ascending OR descending)
     * @return The list of all flowers in ascending or descending order of freshness
     */
    List<flower> sortByFresh(ordersort ordersort);

    /**
     * The method that looks for the maximum price of a flower
     * @return The maximum price of a flower
     */
    Double maxPrice();

    /**
     * The method that looks for the minimum price of a flower
     * @return The minimum price of a flower
     */
    Double minPrice();

    /**
     * The method that looks for the minimum length of a flower
     * @return The minimum price of a flower
     */

    Double minLength();

    /**
     * The method that looks for the maximum length of a flower
     * @return The maximum length of a flower
     */
    Double maxLength();
}
