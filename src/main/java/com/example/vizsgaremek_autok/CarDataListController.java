package com.example.vizsgaremek_autok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CarDataListController implements Initializable {
    @FXML
    private Button ExitButton;
    @FXML
    private Button AddEvent;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView calendarImageView;
    @FXML ImageView carListImageView;
    @FXML
    private ImageView plusImageView;
    @FXML
    private Label brand;
    @FXML
    private Label modell;
    @FXML
    private Label modelYear;
    @FXML
    private Label fuelType;
    @FXML
    private Label carPower;
    @FXML
    private Label gearType;
    @FXML
    private Label color;
    @FXML
    private Label chassisType;
    @FXML
    private Label doors;
    @FXML
    private Label fuelEchonomy;
    @FXML
    private Label licence_plate;
    private LoginModell loginModell;

    public void setLoginModellForCarDataList(LoginModell loginModell) {
        this.loginModell = loginModell;
        try {
            Car car = loadToPojo(carLoad()).getCar();
            brand.setText(car.getBrand());
            modell.setText(car.getModel());
            modelYear.setText(String.valueOf(car.getModelYear()));
            fuelType.setText(car.getFuelType());
            carPower.setText(String.valueOf(car.getCarPower()));
            gearType.setText(car.getGearType());
            color.setText(car.getColor());
            chassisType.setText(car.getChassisType());
            doors.setText(String.valueOf(car.getDoors()));
            fuelEchonomy.setText(car.getFuelEconomy());
            licence_plate.setText(car.getLicense_plate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String carLoad() throws IOException {
        URL url = new URL("http://localhost:3001/userCar/" + loginModell.getLogiResponse().getId());

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET");

        String responseString = "";

        if (httpURLConnection.getResponseCode() == 200) {

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            bufferedReader.close();
            responseString = response.toString();
            System.out.println(responseString);
        } else {
            responseString = "error";
        }
        return responseString;
    }

    public Cardata loadToPojo(String response) throws JsonProcessingException {
        ObjectMapper objectMapper= new ObjectMapper();
       return objectMapper.readValue(response,Cardata.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/TeAutodLogo.png");
        File plusFile= new File("Images/plus.png");
        File calendarImageFile=new File("Images/calendar.png");
        File carListImageFile = new File("Images/carList.png");



        Image brandingImage = new Image(brandingFile.toURI().toString());
        Image plusImageImage = new Image(plusFile.toURI().toString());
        Image calendarImage = new Image(calendarImageFile.toURI().toString());
        Image carListImage = new Image(carListImageFile.toURI().toString());



        brandingImageView.setImage(brandingImage);
        plusImageView.setImage(plusImageImage);
        calendarImageView.setImage(calendarImage);


    }

    public void AddEventOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) AddEvent.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddEvent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 601, 468);
        Stage stage2 = new Stage();
        stage2.setTitle("AddEvent");
        stage2.setScene(scene);
        stage2.show();
    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
}


