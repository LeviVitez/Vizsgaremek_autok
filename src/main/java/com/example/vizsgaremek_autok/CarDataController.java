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
        if(LicencePlateLabel.getText().equals(LicencePlateLabelConfirm.getText())){
            registerCar();
            notMathingLicencePlatesLabel.setText("!");

        }else {
            notMathingLicencePlatesLabel.setText("A megadott rendszámok nem eggyeznek! ");
        }

    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitBut.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerCar(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String carname = CarNameLabel.getText();
        String carbrand = CarBrandLabel.getText();
        String carModel = ModelLabel.getText();
        String carYear = ModelYearLabel.getText();
        String fuel = FuelLabel.getText();
        String carPower = CarPowerLabel.getText();
        String GearType = GearTypeLabel.getText();
        String carColor = ColorLabel.getText();
        String carchassi = ChassiTypeLabel.getText();
        String doors = DoorsLabel.getText();
        String fuelEconomy = FuelEconomyLabel.getText();
        String licencePlate = LicencePlateLabel.getText();

        String insertFields = "INSERT INTO car_data(brand," +
                " model, modelYear, fuelType, carPower," +
                " gearType, doors, fuelEconomy, license_plate, " +
                "givenName) VALUES ('";
        String insertValuse = carname + "','" + carbrand + carModel + carYear + "','" + fuel + "','" +
                carPower + "','" + GearType + "','" + carColor + "','" + carchassi + "','" +
                doors + "','" + fuelEconomy + "','" + licencePlate + "')";

        String insertToRegister = insertFields + insertValuse;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            UploadBut.setText("Autó feltőltáse sikeres!");
        }catch (Exception e){
            e.PrintStackTrace();
            e.getCause();
        }

    }

}
