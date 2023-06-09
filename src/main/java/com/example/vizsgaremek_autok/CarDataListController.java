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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kong.unirest.Unirest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CarDataListController implements Initializable {
    @FXML
    public Button deleteEvent;
    @FXML
    private Button ExitButton;
    @FXML
    private Button AddEvent;
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
    @FXML
    private Label givenameTextField;
    @FXML
    private VBox eventListVbox;
    @FXML
    private ListView<EventResponse> eventListView;
    private LoginModell loginModell;
    private static String titleStatic;
    private static String commentStatic;
    private static String startStatic;
    private List<EventResponse> events;

    public String sendGetEventRequset() throws IOException {
        URL url = new URL("http://localhost:3001/calendarEvent/" + loginModell.getLogiResponse().getId());
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
        } else {
            responseString = "error";
        }
        return responseString;
    }

    public CalData loadToEventPojo(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, new TypeReference<>() {
        });
    }

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
            givenameTextField.setText("A " + car.getGivenName() + " adatai:");
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
        } else {
            responseString = "error";
        }
        return responseString;
    }

    public Cardata loadToPojo(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Cardata.class);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadEventsToList();
        eventListView.setCellFactory(param -> new ListCell<EventResponse>() {
            @Override
            protected void updateItem(EventResponse item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTitle() + " " + item.getComment() + " " + item.getStart());
                }
            }
        });
    }

    public void loadEventsToList() {
        Platform.runLater(() -> {
            try {
                events = (loadToEventPojo(sendGetEventRequset())).getEventResponses();
                eventListView.getItems().clear();
                eventListView.getItems().addAll(events);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void AddEventOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AddEvent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 601, 468);
        ((AddEventController) fxmlLoader.getController()).setLoginModellForAddEventController(loginModell);
        Stage stage2 = new Stage();
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.setTitle("TeAutód.hu");
        stage2.setScene(scene);
        stage2.setOnShown(eventt -> {
            AddEvent.setDisable(true);
            ExitButton.setDisable(true);
            deleteEvent.setDisable(true);
        });
        stage2.setOnCloseRequest(eventt -> {
            AddEvent.setDisable(false);
            ExitButton.setDisable(false);
            deleteEvent.setDisable(false);
            loadEventsToList();
        });
        AddEventController addEventController = fxmlLoader.getController();
        addEventController.setCarDataListController(this);
        stage2.show();
    }

    public void setButtonsEnabled() {
        AddEvent.setDisable(false);
        ExitButton.setDisable(false);
        deleteEvent.setDisable(false);
    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    public void DeleteEventOnAction(ActionEvent event) {
        if (eventListView.getSelectionModel().isEmpty()) {
            return;
        }
        int statusCode = Unirest.delete("http://localhost:3001/calendarEvent/" + eventListView.getSelectionModel().getSelectedItem().getCalId())
                .header("Content-Type", "application/json").asJson().getStatus();
        if (statusCode == 200) {
            loadEventsToList();
        }
    }
}


