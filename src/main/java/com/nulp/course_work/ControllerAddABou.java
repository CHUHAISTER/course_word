package com.nulp.course_work;

import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.items.accessory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.nulp.course_work.Bouquet.addAccessoryFromFilteredListFX;
import static com.nulp.course_work.sortfilter.FilterAccessoriesWithEntering.*;


public class ControllerAddABou implements Initializable {
    private String[] type= {"Jewelry","Ribbon","Bear","Gel ball","Postcard", "Heart"};
    @FXML
    private ChoiceBox<String> BoxForFilterType;

    @FXML
    private ListView<String> filteredaccessories;
    private Stage stage;

    private Scene scene;
    private Parent root;



    public void PrintAllAccessories(ActionEvent e)
    {
        ArrayList<accessory> accessory = filterAllAccessories();
        int i=0;
        filteredaccessories.getItems().clear();
        for (accessory fl: accessory) {
            filteredaccessories.getItems().add(i+". "+fl.toString());
            i++;
        }
    }

    public void PrintPriceAccessories(ActionEvent e)
    {
        // Create the login dialog.
        PriceDialog dialog = new PriceDialog();
        //Get result with lambda syntax
        dialog.showAndWait();
        Pair<Double,Double> price= dialog.getResult();
        filteredaccessories.getItems().clear();
        if(price.getKey()<= price.getValue()) {
            ArrayList<accessory> accessory = filterAccessInPriceRangeFX(price.getKey(), price.getValue());
            int i = 0;
            filteredaccessories.getItems().clear();
            for (accessory fl : accessory) {
                filteredaccessories.getItems().add(i + ". " + fl.toString());
                i++;
            }
        }
        else
        {
            filteredaccessories.getItems().add("No correct range.");
        }
    }


    public void SwitchtoBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("create_bouquet.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BoxForFilterType.getItems().addAll(type);
        BoxForFilterType.setOnAction(this::PrintTypeAccessories);
    }
    public void PrintTypeAccessories(ActionEvent e)
    {
        ArrayList<accessory> accessory =
                filterAccessoriesByTypeFX(accessorytype.getaccessorytype(BoxForFilterType.getValue()));
        int i=0;
        filteredaccessories.getItems().clear();
        for (accessory fl: accessory) {
            filteredaccessories.getItems().add(i+". "+fl.toString());
            i++;
        }
    }

    public void Add(ActionEvent e)
    {
        try {
            int index = filteredaccessories.getSelectionModel().getSelectedIndex();
            addAccessoryFromFilteredListFX(index);
            filteredaccessories.getItems().remove(index);
        }
        catch (Exception ee){}
    }
}

