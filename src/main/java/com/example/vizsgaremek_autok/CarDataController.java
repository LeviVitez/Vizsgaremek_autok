package com.example.vizsgaremek_autok;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kong.unirest.Unirest;

import java.io.IOException;

public class CarDataController {
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
    private Label successfulUploadLabel;
    @FXML
    private Button UploadBut;
    private LoginModell loginModell;


    public void UploadButtonOnAction(ActionEvent event) throws IOException {
        int modelYear = Integer.parseInt(ModelYearLabel.getText());
        int carPower = Integer.parseInt(CarPowerLabel.getText());
        int doors = Integer.parseInt(DoorsLabel.getText());

        CarDataDTO carDataDTO = new CarDataDTO(CarNameLabel.getText(), CarBrandLabel.getText(), ModelLabel.getText(),
                modelYear, FuelLabel.getText(), carPower, GearTypeLabel.getText(),
                ColorLabel.getText(), ChassiTypeLabel.getText(), doors, FuelEconomyLabel.getText(), LicencePlateLabel.getText());
        int status = Unirest.post("http://localhost:3001/car/" + loginModell.getLogiResponse().getId())
                .header("Content-Type", "application/json")
                .body(carDataDTO).asJson().getStatus();
        successfulUploadLabel.setText("Autó feltőltése sikeres!");

        Stage stage = (Stage) UploadBut.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CarDataList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 612, 650);
        Stage stage3 = new Stage();
        stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setTitle("TeAutód.hu");
        ((CarDataListController) fxmlLoader.getController()).setLoginModellForCarDataList(loginModell);
        stage3.setScene(scene);
        stage3.show();
    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitBut.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


    public void setLoginForCarData(LoginModell loginModell) {
        this.loginModell = loginModell;
    }

}
