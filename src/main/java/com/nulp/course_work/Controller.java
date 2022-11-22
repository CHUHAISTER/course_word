package com.nulp.course_work;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;



public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void SwitchtoPrintAssortment(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("print_asort_start.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();


    }
    public void SwitchtoMain(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoFlowerFilter(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flower_filter.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoAccessoryFilter(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("acces_filter.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoChangeAssortment(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("change_assort.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoAddFlower(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addflower.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoAddAccessory(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addacces.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchtoDeleteFlower(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flower_delete.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoDeleteAccessory(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("acces_delete.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoCreateBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("create_bouquet.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoAddFBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flower_add_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoDeleteFBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("delete_flower_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoDeleteABouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("delete_acces_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchtoAddABouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("acces_add_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }


    public void SwitchtoInfoBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("info_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }
    public void SwitchtoBuyBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buy_bou.fxml")));
        stage =  (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Flower Shop");
        stage.setScene(scene);
        stage.show();
    }
    public void Exit(ActionEvent e) throws IOException {
        System.exit(0);
    }
}
