package com.nulp.course_work;

import com.nulp.course_work.items.flower;
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

public class ControllerDeleteFBou implements Initializable {

    @FXML
    private ListView<String> list;
    private Stage stage;

    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i=0;
            for (flower fl : bouquetflowers) {
                if (fl!=null) {
                    list.getItems().add(i + ". " + fl);
                    i++;
                }
            }

    }

    public void Delete(ActionEvent e)
    {

        try {
            int index = list.getSelectionModel().getSelectedIndex();
            deleteflowerFromBouqFX(index);
            list.getItems().remove(index);
        }
        catch (Exception ignored)
        {

        }
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
