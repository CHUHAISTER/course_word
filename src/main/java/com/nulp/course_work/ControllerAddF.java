package com.nulp.course_work;

import com.nulp.course_work.constants.flowertype;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerAddF implements Initializable {
    @FXML
    private ChoiceBox <String> Box;
    private String[] flowerstype= {"Rose", "Lavandula", "Lily", "Lupine", "Tulip", "Daisy",
            "Gardenia", "Orchid", "Gypsophila", "Chamomile", "Chrysanthemum"};
    private Stage stage;

    private Scene scene;
    private Parent root;

    @FXML
    private Label Success;
    @FXML
    private TextField FieldCol;
    @FXML
    private TextField FieldLenght;
    @FXML
    private TextField FieldPrice;
    @FXML
    private TextField FieldNumber;

    @FXML
    private Label Erorr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Box.getItems().addAll(flowerstype);
    }

    public void GetDataandCreate(ActionEvent e) throws IOException {
        Erorr.setText("");
        Success.setText("");
        flowerDB fDB = new flowerDB();
        if (Box.getValue() != null) {
            flowertype Flowertype = flowertype.getflowertype(Box.getValue());
            String colour = FieldCol.getText();
            try {
                double length = Double.parseDouble(FieldLenght.getText());
                double price = Double.parseDouble(FieldPrice.getText());
                int number = Integer.parseInt(FieldNumber.getText());
                fDB.insertWithEnteringFX(number,new flower(Flowertype, colour, length, price));
                FieldLenght.setText("");
                FieldCol.setText("");
                FieldPrice.setText("");
                FieldNumber.setText("");
                Erorr.setText("");
                Success.setText("Success add flowers.");
            }
            catch (Exception ee)
            {
                Erorr.setText("No correct data.");
            }

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
}
