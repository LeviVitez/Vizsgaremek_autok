package com.example.vizsgaremek_autok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kong.unirest.Unirest;

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
    private ComboBox<String> titleComboBox;
    @FXML
    private TextField commentTextField;
    @FXML
    private TextField StartTextField;
    @FXML
    private Label ErrorLabel;
    private LoginModell loginModell;
    private static String titleStatic;
    private static String commentStatic;
    private static String startStatic;
    private CarDataListController carDataListController;

    public void setLoginModellForAddEventController(LoginModell loginModell) {
        this.loginModell = loginModell;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File addeventfile = new File("Images/addevent.png");
        Image addeventimage = new Image(addeventfile.toURI().toString());
        AddeventImageView.setImage(addeventimage);
        titleComboBox.getItems().addAll("Tankolás", "Büntetés", "Biztosítás", "Szervíz", "Műszaki vizsga", "Havi szemle", "Pályamatrica", "Gépjárműadó", "Parkolás", "Autómosás", "Befizetés", "Egyéb");
    }

    public void EsemenyAddOnAction(ActionEvent event) throws IOException {
        if (titleComboBox.getValue() != null && StartTextField.getText().isBlank() == false && commentTextField.getText().isBlank() == false) {
            int statusCode = sendEventRequest();
            if (statusCode == 200){
                titleStatic = titleComboBox.getValue();
                commentStatic = commentTextField.getText().trim();
                startStatic = StartTextField.getText().trim();
                Stage stage = (Stage) EsemenyAddButton.getScene().getWindow();
                carDataListController.loadEventsToList();
                stage.close();
                carDataListController.setButtonsEnabled();
            }else {

            }
        } else {
            ErrorLabel.setText("Kérjük töltse ki az összes mezőt!");
        }
    }

    public int sendEventRequest(){
        String requstString = String.format("""
                    {
                      "calid": null,
                      "title": "%s",
                      "start": "%s",
                    "comment": "%s",
                      "carData": null
                    }""",titleComboBox.getValue(),StartTextField.getText().trim(),commentTextField.getText().trim());


         return Unirest.post("http://localhost:3001/calendarEvent/"+loginModell.getLogiResponse().getId())
                .header("Content-Type", "application/json")
                .body(requstString).asJson().getStatus();
    }

    public void megseOnButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) megseButton.getScene().getWindow();
        stage.close();
        carDataListController.setButtonsEnabled();
    }

    public void setCarDataListController(CarDataListController carDataListController) {
        this.carDataListController = carDataListController;

    }

}
