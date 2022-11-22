package com.nulp.course_work.sortfilter;

import com.nulp.course_work.Database;
import com.nulp.course_work.constants.flowertype;
import com.nulp.course_work.constants.ordersort;
import com.nulp.course_work.items.flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.nulp.course_work.Database.getConnection;


public class SortFilterflowersDB implements SortFilterflowersInter {
    public static final Logger LOGI = (Logger) LogManager.getLogger(SortFilterflowersDB.class);

    private static final String GET_ALL_flower = "SELECT * FROM flowers";

    private static final String SORT_BY_TYPE_flower = "SELECT * FROM flowers WHERE flowertypeID = ?";

    private static final String SORT_BY_FRESH_flower = "SELECT flowerID, flowertypeID, flowerColour, flowerLength, " +
            "flowerPrice, fDateDelivery FROM flowers ORDER BY fDateDelivery ";

    private static final String FILTER_flowerS_IN_PRICE_RANGE = "SELECT * FROM flowers WHERE flowerPrice >= ? AND" +
            " flowerPrice <= ? ";

    private static final String FILTER_flowerS_IN_LENGTH_RANGE = "SELECT * FROM flowers WHERE flowerLength >= ? AND" +
            " flowerLength <= ? ";

    private static final String MIN_PRICE_flower = "SELECT MIN(flowerPrice) FROM flowers";

    private static final String MAX_PRICE_flower = "SELECT MAX(flowerPrice) FROM flowers";

    private static final String MIN_LENGTH_flower = "SELECT MIN(flowerLength) FROM flowers";

    private static final String MAX_LENGTH_flower = "SELECT MAX(flowerLength) FROM flowers";


    /**
     * The method that returns all flowers from database
     * @return The list of all flowers from database
     */
    @Override
    public ArrayList<flower> getAll() {
        Database.connection = getConnection();
        ArrayList<flower> flowers = new ArrayList<>();
        flower flower = null;
        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_ALL_flower);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                flower = flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setflowertype(flowertype.getflowertype(rs.getInt("flowertypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();
                LOGI.info("Get all flowers.");
                flowers.add(flower);
            }
        } catch (SQLException e) {
            LOGI.error("Something went wrong! Сan`t get all flowers!");
        }
        return flowers;
    }


    public ArrayList<flower> filterInRangeWithStatement(double min, double max, String statement){
        Database.connection = getConnection();
        ArrayList<flower> flowers = new ArrayList<>();
        try {
            PreparedStatement ps = Database.connection.prepareStatement(statement);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            flower flower = null;
            while(rs.next()){
                flower = flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setflowertype(flowertype.getflowertype(rs.getInt("flowertypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();

                flowers.add(flower);
            }
        } catch (SQLException e) {
            LOGI.error("Something went wrong! Сan`t get flowers by range! Try again!");
        }
        return flowers;
    }

    /**
     * The method that searches for flowers in a price range in database
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the price range in database
     */
    @Override
    public ArrayList<flower> filterInPriceRange(double min, double max) {
        LOGI.info("Get flowers in range "+ min +  " - " + max + "price.");
        return filterInRangeWithStatement(min, max, FILTER_flowerS_IN_PRICE_RANGE);
    }

    /**
     * The method that searches for flowers in a length range from database
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of flowers in the length range from database
     */
    @Override
    public ArrayList<flower> filterInLengthRange(double min, double max) {
        LOGI.info("Get flowers in range "+ min +  " - " + max + "lenght.");
        return filterInRangeWithStatement(min, max, FILTER_flowerS_IN_LENGTH_RANGE);
    }

    /**
     * The method that searches for flowers of a given type from database
     * @param flowertype The flower type
     * @return The list of flowers of a given type
     */
    @Override
    public ArrayList<flower> sortByType(flowertype flowertype) {
        Database.connection = getConnection();
        ArrayList<flower> flowers = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(SORT_BY_TYPE_flower);
            ps.setInt(1, flowertype.getNumType());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                flower flower = null;
                flower = flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setflowertype(flowertype.getflowertype(rs.getInt("flowertypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();
                LOGI.info("Get flowers current type.");
                flowers.add(flower);
            }
        } catch (SQLException e) {
            LOGI.error("Something went wrong! Сan`t get flowers filtered by type!");
        }
        return flowers;
    }

    /**
     * The method that sorts all flowers in ascending or descending order of freshness from database
     * @param sort Sorting type (ascending OR descending)
     * @return The list of all flowers in ascending or descending order of freshness from database
     */
    @Override
    public ArrayList<flower> sortByFresh(ordersort sort) {
        Database.connection = getConnection();
        ArrayList<flower> flowers = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(SORT_BY_FRESH_flower + sort);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                flower flower = null;
                flower = flower.builder()
                        .setId(rs.getInt("flowerID"))
                        .setflowertype(flowertype.getflowertype(rs.getInt("flowertypeID")))
                        .setColour(rs.getString("flowerColour"))
                        .setLength(rs.getDouble("flowerLength"))
                        .setPrice(rs.getDouble("flowerPrice"))
                        .setDate(rs.getDate("fDateDelivery"))
                        .built();
                LOGI.info("Get flowers for fresh.");

                flowers.add(flower);
            }
        } catch (SQLException e) {
            LOGI.error("Something went wrong! Сan`t get flowers sorted by fresh! Try again!");
        }
        return flowers;
    }

    /**
     * The method that processes a sql query to find some maximum or minimum value from database
     * @param statement The statement of sql query
     * @return The min or max value
     */
    public Double minOrMaxStatement(String statement){
        Database.connection = getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            LOGI.error("Error. Not correct data.");
        }
        return null;
    }

    /**
     * The method that looks for the maximum price of a flower in database
     * @return The maximum price of a flower in database
     */
    @Override
    public Double maxPrice() {
        return minOrMaxStatement(MAX_PRICE_flower);
    }

    /**
     * The method that looks for the minimum price of a flower in database
     * @return The minimum price of a flower in database
     */
    @Override
    public Double minPrice() {
        return minOrMaxStatement(MIN_PRICE_flower);
    }

    /**
     * The method that looks for the minimum length of a flower in database
     * @return The minimum price of a flower
     */
    @Override
    public Double minLength(){
        return minOrMaxStatement(MIN_LENGTH_flower);
    }

    /**
     * The method that looks for the maximum length of a flower in database
     * @return The maximum length of a flower in database
     */
    @Override
    public Double maxLength(){
        return minOrMaxStatement(MAX_LENGTH_flower);
    }
}
