package com.nulp.course_work;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Pair;
import java.io.IOException;
public class PriceDialog extends Dialog<Pair<Double, Double>> {
    @FXML
    private TextField minpricefield;
    @FXML
    private TextField maxpricefield;
    public static ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    public PriceDialog() {
        setDefaultInformation();
        setDefaultButtons();
        setContent();
        setBehaviour();
    }
    private void setDefaultInformation() {
        //Default login prompt information
        setTitle("Range price");
        setHeaderText("Range price");
    }
    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(loginButtonType, ButtonType.CANCEL);
    }
    private void setContent() {
        //Create the content using FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("price_range.fxml"));
        loader.setController(this);
        try {
            getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setBehaviour() {
        // If username and password have both been set, return values, else return null
        setResultConverter(dialogButton ->
                !minpricefield.getText().isBlank() && !maxpricefield.getText().isBlank()
                        ? new Pair<>(Double.parseDouble(minpricefield.getText()), Double.parseDouble(maxpricefield.getText()))
                        : null
        );

        //Only enable login button when username and password have both been entered
        Node loginButton = getDialogPane().lookupButton(PriceDialog.loginButtonType);
        loginButton.disableProperty()
                .bind(Bindings.or(
                        minpricefield.textProperty().isEmpty(),
                        maxpricefield.textProperty().isEmpty()
                ));
    }

}