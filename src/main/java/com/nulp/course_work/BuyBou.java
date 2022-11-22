package com.nulp.course_work;

import com.nulp.course_work.items.accessory;
import com.nulp.course_work.items.flower;
import com.nulp.course_work.itemwithDB.AccessoryDB;
import com.nulp.course_work.itemwithDB.flowerDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.nulp.course_work.Bouquet.*;

public class BuyBou implements Initializable {

    @FXML
    private ListView<String> info_list;
    private Stage stage;

    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info_list.getItems().add("Flowers:");
        info_list.getItems().add("");
        int i=0;
        for (flower fl: bouquetflowers)
        {
            if (fl!=null) {
                info_list.getItems().add(i + ". " + fl.toString());
                i++;
            }
        }
        info_list.getItems().add("Accessories:");
        info_list.getItems().add("");
        i=0;
        for (accessory fl: bouquetAccessories)
        {
            if (fl!=null) {
                info_list.getItems().add(i + ". " + fl.toString());
                i++;
            }
        }
        info_list.getItems().add("");
        info_list.getItems().add("The price of bouquet: " + priceOfBouquet());
        info_list.getItems().add("");
        info_list.getItems().add("The average length flower in bouquet: " + averageLengthOfflowers());
        info_list.getItems().add("");
        info_list.getItems().add("Sold a bouquet");
        AccessoryDB aDao = new AccessoryDB();
        aDao.deleteAllFromBouquet();
        flowerDB fDao = new flowerDB();
        fDao.deleteAllFromBouquet();
    }

    public void Back(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("create_bouquet.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }
}
