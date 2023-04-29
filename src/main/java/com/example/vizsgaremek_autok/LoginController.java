package com.example.vizsgaremek_autok;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import java.io.*;
import java.awt.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class LoginController {
    @FXML
    private Button ExitButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterpasswordField;
    @FXML
    private Button loginButton;
    public String userId;
    public String token;
    public String responseString;
    private LoginModell loginModell;

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if (usernameTextField.getText().isBlank() == false && enterpasswordField.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void validateLogin() throws IOException {
        try {
            LoginDTO loginDTO = new LoginDTO(usernameTextField.getText(), enterpasswordField.getText());
            HttpResponse<JsonNode> response = Unirest.post("http://localhost:3001/auth/login")
                    .header("Content-Type", "application/json")
                    .body(loginDTO).asJson();
            int status = response.getStatus();
            if (status == 201) {
                JSONObject responseBody = response.getBody().getObject();
                userId = responseBody.getString("userId");
                token = responseBody.getString("token");
                LogiResponse logiResponse = new LogiResponse(Integer.parseInt(userId), token);
                loginModell = new LoginModell(logiResponse);
                loginMessageLabel.setText("Succesful Login!");
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                URL url = new URL("http://localhost:3001/userCar/" + userId);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response2 = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response2.append(line);
                    }
                    bufferedReader.close();
                    responseString = response2.toString();
                } else {
                    responseString = "error";
                }

                //ha van auto akkor egybol az adatait mutatja, ha nincs felkell venni
                if (responseString.length() == 13) {
                    //ez azert 13 mert a {"cars":null} 13 betű
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CarData.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1079, 898);
                    Stage stage2 = new Stage();
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.setTitle("TeAutód.hu");
                    stage2.setScene(scene);
                    ((CarDataController) fxmlLoader.getController()).setLoginForCarData(loginModell);
                    stage2.show();
                } else {
                    stage.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CarDataList.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 612, 650);
                    Stage stage3 = new Stage();
                    stage3.setTitle("TeAutód.hu");
                    stage3.initStyle(StageStyle.UNDECORATED);
                    ((CarDataListController) fxmlLoader.getController()).setLoginModellForCarDataList(loginModell);
                    stage3.setScene(scene);
                    stage3.show();
                }
            } else {
                loginMessageLabel.setText("Username or Password doesn't match. Please try Again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    public void RegisterLinkOnAction(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("http://localhost:3000/register"));
    }
}