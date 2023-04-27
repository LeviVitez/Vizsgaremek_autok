package com.example.vizsgaremek_autok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddEvent implements Initializable {
@FXML
private ImageView AddeventImageView;
@FXML
private Button megseButton;
@FXML
private ComboBox<String> Events;

@FXML
private Button Hozzaad;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File addeventfile = new File("Images/addevent.png");
        Image addeventimage = new Image(addeventfile.toURI().toString());
        AddeventImageView.setImage(addeventimage);
        Events.getItems().addAll("Tankolás","Büntetés","Biztosítás","Szervíz","Műszaki vizsga","Havi szemle","Pályamatrica","Gépjárműadó","Parkolás","Autómosás","Befizetés","Egyéb");
    }

    public void AddEventOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddEvent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 601, 468);
        Stage stage2 = new Stage();
        stage2.setTitle("AddEvent");
        stage2.setScene(scene);
        stage2.show();
    }

    public void megseOnButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) megseButton.getScene().getWindow();
        stage.close();
    }
}
