package com.example.vizsgaremek_autok;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kong.unirest.Unirest;

import java.io.Console;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;


public class AddEventController implements Initializable {
    @FXML
    private ImageView AddeventImageView;
    @FXML
    private Button megseButton;
    @FXML
    private Button EsemenyAddButton;
    @FXML
    private ComboBox<String> Events;
    @FXML
    private ComboBox titleComboBox;
    @FXML
    private TextField CommentTextField;
    @FXML
    private TextField StartTextField;
    private LoginModell loginModell;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File addeventfile = new File("Images/addevent.png");
        Image addeventimage = new Image(addeventfile.toURI().toString());
        AddeventImageView.setImage(addeventimage);
        titleComboBox.getItems().addAll("Tankolás", "Büntetés", "Biztosítás", "Szervíz", "Műszaki vizsga", "Havi szemle", "Pályamatrica", "Gépjárműadó", "Parkolás", "Autómosás", "Befizetés", "Egyéb");
    }

    public void EsemenyAddOnAction(ActionEvent event) throws IOException {
        AddEventDTO addEventDTO = new AddEventDTO((String) titleComboBox.getValue(), StartTextField.getText(), CommentTextField.getText());
        int status = Unirest.post("http://localhost:3001/calendarEvent/9")//+ loginModell.getLogiResponse().getId())
                .header("Content-Type", "application/json")
                .body(addEventDTO).asJson().getStatus();
        //Stage stage = (Stage) EsemenyAddButton.getScene().getWindow();
        //stage.close();
    }


    public void megseOnButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) megseButton.getScene().getWindow();
        stage.close();
    }
}
