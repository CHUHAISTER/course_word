package com.nulp.course_work.itemwithDB;

import com.nulp.course_work.Database;
import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.inputoutput.InputControl;
import com.nulp.course_work.items.accessory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.nulp.course_work.Bouquet.bouquetAccessories;
import static com.nulp.course_work.inputoutput.InputControl.enterCorrectIndexAccessory;
import static com.nulp.course_work.inputoutput.output.printInfoEntering;
import static com.nulp.course_work.sortfilter.FilterAccessoriesWithEntering.filteredAccessories;

public class AccessoryDB implements  ItemDB<accessory>{
    public static final Logger LOGI = (Logger) LogManager.getLogger(AccessoryDB.class);

    private static final String GET_ACCESSORY_BY_ID = "SELECT * FROM dbo.accessories WHERE accessoryID = ?";
    private static final String DELETE_ACCESSORY_BY_ID = "DELETE FROM dbo.accessories WHERE accessoryID = ?";
    private static final String INSERT_ACCESSORY = "INSERT INTO dbo.accessories (accessoryTypeID, accessoryColour," +
            " accessoryPrice, accessoryInfo) VALUES( ?, ?, ?, ?);";


    @Override
    public accessory getById(int id) {
        Database.connection = Database.getConnection();
        accessory accessory = null;

        try {
            PreparedStatement ps = Database.connection.prepareStatement(GET_ACCESSORY_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                accessory = accessory.builder()
                        .setId(rs.getInt("accessoryID"))
                        .setaccessorytype(accessorytype.getaccessorytype(rs.getInt("accessoryTypeID")))
                        .setColour(rs.getString("accessoryColour"))
                        .setPrice(rs.getDouble("accessoryPrice"))
                        .setInfo(rs.getString("accessoryInfo"))
                        .built();
            }
            LOGI.info("Get by ID accessory.");

            return accessory;

        } catch (SQLException e) {
            LOGI.error("Detect error while searching accessory! ");
        }
        return null;
    }

    @Override
    public int delete(accessory accessory) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(DELETE_ACCESSORY_BY_ID);
            ps.setInt(1, accessory.getId());
            LOGI.info("Delete accessory.");
            return ps.executeUpdate();

        } catch (SQLException e) {
            LOGI.error("Detect error while deleting accessory!  ");
            return 0;
        }
    }

    @Override
    public int insert(accessory accessory) {
        Database.connection = Database.getConnection();

        try {
            PreparedStatement ps = Database.connection.prepareStatement(INSERT_ACCESSORY);
            ps.setInt(1, accessory.getaccessorytype().getNumType());
            ps.setString(2, accessory.getColour());
            ps.setDouble(3,  accessory.getPrice());
            ps.setString(4,  accessory.getInfo());
            LOGI.info("Insert accessory.");

            return ps.executeUpdate();

        } catch (SQLException e) {
            LOGI.error("Detect error during insertion accessory! ");
            return 0;
        }
    }

    @Override
    public void insertWithEntering(){
        accessory accessory = new accessory.accessorybuilder()
                .setaccessorytype()
                .setColour()
                .setPrice()
                .setInfo()
                .built();

        printInfoEntering("Enter how many such accessories you want to add (is it one accessory or a whole batch)." +
                "\nEnter a number: ");

        int count = InputControl.enterCorrectInt();

        int added = 0;
        for(int i = 0; i < count; i++) if(insert(accessory) == 1) added++;

        if(added == count){
            System.out.println("\n The accessories were successfully added!");
        }
        LOGI.info("Insert accessory. " + added + "elems.");

    }

    public void insertWithEnteringFX(int count, accessory accessory){
        int added = 0;
        for(int i = 0; i < count; i++) if(insert(accessory) == 1) added++;
        LOGI.info("Insert accessory. " + added + "elems.");

    }
    @Override
    public void deleteFromFiltered() {
        accessory accessory = enterCorrectIndexAccessory(filteredAccessories);
        if(accessory != null){
            delete(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
        LOGI.info("Delete for filtered accessory.");
    }


    public void deleteFromFilteredFX(int index) {
        accessory accessory = filteredAccessories.get(index);
        if(accessory != null){
            delete(accessory);
            filteredAccessories.set(filteredAccessories.indexOf(accessory), null);
        }
        LOGI.info("Delete for filtered accessory.");
    }
    public void deleteAllFromBouquet(){
        for(accessory accessory : bouquetAccessories){
            delete(accessory);
        }
        bouquetAccessories.clear();
        LOGI.info("Delete accessory from bouquet.");

    }
}
