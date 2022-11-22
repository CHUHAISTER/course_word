package com.nulp.course_work;

import com.nulp.course_work.constants.flowertype;
import com.nulp.course_work.constants.ordersort;
import com.nulp.course_work.items.flower;
import com.nulp.course_work.itemwithDB.flowerDB;
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

import static com.nulp.course_work.sortfilter.FilterflowersWithEntering.*;

public class ControllerDeleteF implements Initializable {
    private String[] flowerstype= {"Rose", "Lavandula", "Lily", "Lupine", "Tulip", "Daisy",
            "Gardenia", "Orchid", "Gypsophila", "Chamomile", "Chrysanthemum"};
    private String[] sort = {"In descending order", "In ascending order"};
    @FXML
    private ChoiceBox<String> BoxForFilterType;
    @FXML
    private ChoiceBox<String> BoxFilterForFresh;

    @FXML
    private ListView<String> filteredflower;
    private Stage stage;

    private Scene scene;
    private Parent root;



    public void PrintAllFlowers(ActionEvent e)
    {
        ArrayList<flower> allflower = filterAllflowers();
        int i=0;
        filteredflower.getItems().clear();
        for (flower fl: allflower) {
            filteredflower.getItems().add(i+". "+fl.toString());
            i++;
        }
    }

    public void PrintPriceFlowers(ActionEvent e)
    {
        // Create the login dialog.
        PriceDialog dialog = new PriceDialog();
        //Get result with lambda syntax
        dialog.showAndWait();
        Pair<Double,Double> price= dialog.getResult();
        filteredflower.getItems().clear();
        if(price.getKey()<= price.getValue()) {
            ArrayList<flower> allflower = filterflowersInPriceRangeFX(price.getKey(), price.getValue());
            int i = 0;
            filteredflower.getItems().clear();
            for (flower fl : allflower) {
                filteredflower.getItems().add(i + ". " + fl.toString());
                i++;
            }
        }
        else
        {
            filteredflower.getItems().add("No correct range.");
        }
    }

    public void PrintLenghtFlowers(ActionEvent e)
    {
        // Create the login dialog.
        LenghtDialog dialog = new LenghtDialog();
        //Get result with lambda syntax
        dialog.showAndWait();
        Pair<Double,Double> lenght= dialog.getResult();
        filteredflower.getItems().clear();
        if(lenght.getKey()<= lenght.getValue()){
            ArrayList<flower> allflower = filterflowersInLengthRangeFX(lenght.getKey(), lenght.getValue());
            int i=0;
            filteredflower.getItems().clear();
            for (flower fl: allflower) {
                filteredflower.getItems().add(i+". "+fl.toString());
                i++;
            }
        }
        else
        {
            filteredflower.getItems().add("No correct range.");
        }
    }
    public void SwitchtoMain(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BoxForFilterType.getItems().addAll(flowerstype);
        BoxForFilterType.setOnAction(this::PrintTypeFlowers);
        BoxFilterForFresh.getItems().addAll(sort);
        BoxFilterForFresh.setOnAction(this::PrintFreshFlowers);

    }
    public void PrintTypeFlowers(ActionEvent e)
    {
        ArrayList<flower> allflower = filterflowersByTypeFX(flowertype.getflowertype(BoxForFilterType.getValue()));
        int i=0;
        filteredflower.getItems().clear();
        for (flower fl: allflower) {
            filteredflower.getItems().add(i+". "+fl.toString());
            i++;
        }
    }

    public void PrintFreshFlowers(ActionEvent e)
    {
        ArrayList<flower> allflower = sortflowersByFreshFX(ordersort.getordersortype(BoxFilterForFresh.getValue()));
        int i=0;
        filteredflower.getItems().clear();
        for (flower fl: allflower) {
            filteredflower.getItems().add(i+". "+fl.toString());
            i++;
        }
    }

    public void Delete(ActionEvent e)
    {
        try {
            flowerDB flowerDao = new flowerDB();
            int index = filteredflower.getSelectionModel().getSelectedIndex();
            flowerDao.deleteFromFilteredFX(index);
            filteredflower.getItems().remove(index);
        }
        catch (Exception ee){}
    }
}
