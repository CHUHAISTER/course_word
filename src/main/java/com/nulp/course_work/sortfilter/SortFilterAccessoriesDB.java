package com.nulp.course_work.sortfilter;

import com.nulp.course_work.Database;
import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.items.accessory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SortFilterAccessoriesDB implements SortFilterAccessoriesInter {
    public static final Logger LOGI = (Logger) LogManager.getLogger(SortFilterAccessoriesDB.class);

    private static final String GET_ALL_accessory = "SELECT * FROM accessories";

    private static final String SORT_BY_TYPE_accessory = "SELECT * FROM accessories WHERE accessoryTypeID = ?";

    private static final String FILTER_ACCESSORIES_IN_PRICE_RANGE = "SELECT * FROM accessories WHERE accessoryPrice >= ? AND" +
            " accessoryPrice <= ? ";

    private static final String MAX_PRICE_accessory = "SELECT MAX(accessoryPrice) FROM accessories";

    private static final String MIN_PRICE_accessory = "SELECT MIN(accessoryPrice) FROM accessories";

    /**
     * The method that returns all accessories from database
     * @return The list of all accessories from database
     */

    @Override
    public ArrayList<accessory> getAll() {
        Database.connection = Database.getConnection();
        ArrayList<accessory> accessories = new ArrayList<accessory>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_ALL_accessory);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                accessory accessory = null;
                accessory = accessory.builder()
                        .setId(rs.getInt("accessoryID"))
                        .setaccessorytype(accessorytype.getaccessorytype(rs.getInt("accessoryTypeID")))
                        .setColour(rs.getString("accessoryColour"))
                        .setPrice(rs.getDouble("accessoryPrice"))
                        .setInfo(rs.getString("accessoryInfo"))
                        .built();
                LOGI.info("Get all accessory.");

                accessories.add(accessory);
            }
        } catch (SQLException e) {
            LOGI.error("Error. Сan`t get all accessories!");
        }
        return accessories;
    }

    /**
     * The method that searches for accessories in a price range from database
     * @param min The minimum search limit
     * @param max The maximum search limit
     * @return The list of accessories in the price range from database
     */
    @Override
    public ArrayList<accessory> filterInPriceRange(Double min, Double max) {
        Database.connection = Database.getConnection();
        ArrayList<accessory> accessories = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(FILTER_ACCESSORIES_IN_PRICE_RANGE);
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                accessory accessory = null;
                accessory = accessory.builder()
                        .setId(rs.getInt("accessoryID"))
                        .setaccessorytype(accessorytype.getaccessorytype(rs.getInt("accessoryTypeID")))
                        .setColour(rs.getString("accessoryColour"))
                        .setPrice(rs.getDouble("accessoryPrice"))
                        .setInfo(rs.getString("accessoryInfo"))
                        .built();
                LOGI.info("Get accessory in range "+ min +  " - " + max + "price.");

                accessories.add(accessory);
            }
        } catch (SQLException e) {
            LOGI.error("Error! Сan`t get accessories filtered by type! Try again!");
        }
        return accessories;
    }

    /**
     * The method that searches for flowers of a given type from database
     * @param accessoryType The accessory type
     * @return The list of accessories of a given type from database
     */

    public ArrayList<accessory> sortByType(accessorytype accessoryType) {
        Database.connection = Database.getConnection();
        ArrayList<accessory> accessories = new ArrayList<>();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(SORT_BY_TYPE_accessory);
            ps.setInt(1, accessoryType.getNumType());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                accessory accessory = null;
                accessory = accessory.builder()
                        .setId(rs.getInt("accessoryID"))
                        .setaccessorytype(accessorytype.getaccessorytype(rs.getInt("accessoryTypeID")))
                        .setColour(rs.getString("accessoryColour"))
                        .setPrice(rs.getDouble("accessoryPrice"))
                        .setInfo(rs.getString("accessoryInfo"))
                        .built();
                accessories.add(accessory);
            }
            LOGI.info("Get accessory current type.");
        } catch (SQLException e) {
            LOGI.error("Error. Сan`t get accessories filtered by type! Try again!");
        }
        return accessories;
    }

    /**
     * The method that processes a sql query to find some maximum or minimum value from database
     * @param statement The statement of sql query
     * @return The min or max value
     */
    public Double minOrMaxStatement(String statement){
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            LOGI.error("Error. Find problem.");
        }
        return null;
    }

    /**
     * The method that looks for the maximum price of an accessory from database
     * @return The maximum price of an accessory from database
     */
    @Override
    public Double minPrice() {
        return minOrMaxStatement(MIN_PRICE_accessory);
    }

    /**
     * The method that looks for the minimum price of an accessory in database
     * @return The minimum price of an accessory in database
     */
    @Override
    public Double maxPrice() {
        return minOrMaxStatement(MAX_PRICE_accessory);
    }
}
