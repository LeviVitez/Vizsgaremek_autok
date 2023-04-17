package com.example.vizsgaremek_autok;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.Statement;

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
    private TextField LicencePlateLabelConfirm;
    @FXML
    private Button UploadBut;
    @FXML
    private Button ExitBut;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField notMathingLicencePlatesLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/MicrosoftTeams-image.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }

    public void RegisterButtonOnAction (ActionEvent event){
        UploadBut.setText("Autó feltőltáse sikeres!");
        registerCar();
    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitBut.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerCar(){
        if(LicencePlateLabel.getText().equals(LicencePlateLabelConfirm.getText())){
            notMathingLicencePlatesLabel.setText("Megegyező mezők!");
        }else {
            notMathingLicencePlatesLabel.setText("A megadott rendszámok nem eggyeznek! ");
        }
    }

}
