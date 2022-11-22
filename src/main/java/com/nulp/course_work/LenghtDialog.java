package com.nulp.course_work;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Pair;
import java.io.IOException;
public class LenghtDialog extends Dialog<Pair<Double, Double>> {
    @FXML
    private TextField minlenghtfield;
    @FXML
    private TextField maxlenghtfield;
    public static ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    public LenghtDialog() {
        setDefaultInformation();
        setDefaultButtons();
        setContent();
        setBehaviour();
    }
    private void setDefaultInformation() {
        //Default login prompt information
        setTitle("Range lenght");
        setHeaderText("Range lenght");
    }
    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(loginButtonType, ButtonType.CANCEL);
    }
    private void setContent() {
        //Create the content using FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("lenght_range.fxml"));
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
                !minlenghtfield.getText().isBlank() && !maxlenghtfield.getText().isBlank()
                        ? new Pair<>(Double.parseDouble(minlenghtfield.getText()), Double.parseDouble(maxlenghtfield.getText()))
                        : null
        );

        //Only enable login button when username and password have both been entered
        Node loginButton = getDialogPane().lookupButton(LenghtDialog.loginButtonType);
        loginButton.disableProperty()
                .bind(Bindings.or(
                        minlenghtfield.textProperty().isEmpty(),
                        maxlenghtfield.textProperty().isEmpty()
                ));
    }

}
