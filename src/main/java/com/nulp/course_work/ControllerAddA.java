package com.nulp.course_work;

import com.nulp.course_work.constants.accessorytype;
import com.nulp.course_work.constants.flowertype;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerAddA implements Initializable {
    @FXML
    private ChoiceBox <String> Box;


    private String[] type= {"Jewelry","Ribbon","Bear","Gel ball","Postcard", "Heart"};
    private Stage stage;

    private Scene scene;
    private Parent root;

    @FXML
    private Label Success;
    @FXML
    private TextField FieldCol;
    @FXML
    private TextField FieldInfo;
    @FXML
    private TextField FieldPrice;
    @FXML
    private TextField FieldNumber;

    @FXML
    private Label Erorr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Box.getItems().addAll(type);
    }

    public void GetDataandCreate(ActionEvent e) throws IOException {
        Erorr.setText("");
        Success.setText("");
        AccessoryDB aDao = new AccessoryDB();
        if (Box.getValue() != null) {
            accessorytype type = accessorytype.getaccessorytype(Box.getValue());
            String colour = FieldCol.getText();
            String info = FieldInfo.getText();
            try {
                double price = Double.parseDouble(FieldPrice.getText());
                int number = Integer.parseInt(FieldNumber.getText());
                aDao.insertWithEnteringFX(number,new accessory(type, colour, price, info));
                FieldInfo.setText("");
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
