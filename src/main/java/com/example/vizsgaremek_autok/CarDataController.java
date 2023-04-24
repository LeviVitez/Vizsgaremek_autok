package com.example.vizsgaremek_autok;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import kong.unirest.Unirest;

import java.io.Console;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CarDataController implements Initializable {
    @FXML
    private TextField CarNameLabel;
    @FXML
    private TextField CarBrandLabel;
    @FXML
    private TextField ModelLabel;
    @FXML
    private TextField ModelYearLabel;
    @FXML
    private TextField FuelLabel;
    @FXML
    private TextField CarPowerLabel;
    @FXML
    private TextField GearTypeLabel;
    @FXML
    private TextField ColorLabel;
    @FXML
    private TextField ChassiTypeLabel;
    @FXML
    private TextField DoorsLabel;
    @FXML
    private TextField FuelEconomyLabel;
    @FXML
    private TextField LicencePlateLabel;
    @FXML
    private Button ExitBut;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Label successfulUploadLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/MicrosoftTeams-image.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }

    public void UploadButtonOnAction(ActionEvent event) {
        int modelYear = Integer.parseInt(ModelYearLabel.getText());
        int carPower = Integer.parseInt(CarPowerLabel.getText());
        int doors = Integer.parseInt(DoorsLabel.getText());

        CarDataDTO carDataDTO = new CarDataDTO(CarNameLabel.getText(), CarBrandLabel.getText(), ModelLabel.getText(),
                modelYear, FuelLabel.getText(), carPower, GearTypeLabel.getText(),
                ColorLabel.getText(),ChassiTypeLabel.getText(), doors,FuelEconomyLabel.getText(), LicencePlateLabel.getText());
        int status = Unirest.post("http://localhost:3001/car/9")
                .header("Content-Type", "application/json")
                .body(carDataDTO).asJson().getStatus();
        successfulUploadLabel.setText("Autó feltőltése sikeres!");
    }


    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitBut.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

}
