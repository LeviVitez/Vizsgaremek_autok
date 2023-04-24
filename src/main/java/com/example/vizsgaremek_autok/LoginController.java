package com.example.vizsgaremek_autok;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import java.io.File;
import java.util.ResourceBundle;
import java.net.URL;

public class LoginController implements Initializable {
    @FXML
    private Button ExitButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterpasswordField;
    @FXML
    private Button loginButton;
    public String userId;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/MicrosoftTeams-image.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isBlank() == false && enterpasswordField.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }


    public void ExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }


        public void validateLogin() {
            try {
                LoginDTO loginDTO = new LoginDTO(usernameTextField.getText(), enterpasswordField.getText());
                HttpResponse<JsonNode> response = Unirest.post("http://localhost:3001/auth/login")
                        .header("Content-Type", "application/json")
                        .body(loginDTO).asJson();
                int status = response.getStatus();
                if (status == 201) {
                    JSONObject responseBody = response.getBody().getObject();
                    userId = responseBody.getString("userId");
                    System.out.println(userId);

                    loginMessageLabel.setText("Succesful Login!");
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CarData.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 520, 802);
                    Stage stage2 = new Stage();
                    stage2.initStyle(StageStyle.UNDECORATED);
                    stage2.setTitle("Logged In");
                    stage2.setScene(scene);
                    stage2.show();
                } else {
                    loginMessageLabel.setText("Username or Password doesn't match. Please try Again.");
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
    public String getUserId() {
        return userId;
    }



    /*public class Constants {
        public static String UserId=userid;
    }


    public void validateLogin() {
        try {
            LoginDTO loginDTO = new LoginDTO(usernameTextField.getText(), enterpasswordField.getText());
            int status = Unirest.post("http://localhost:3001/auth/login")
                    .header("Content-Type", "application/json")
                    .body(loginDTO).asJson().getStatus();
            if (status == 201) {

                loginMessageLabel.setText("Succesful Login!");
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();



                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CarData.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 520, 802);
                Stage stage2 = new Stage();
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.setTitle("Logged In");
                stage2.setScene(scene);
                stage2.show();
            } else {
                loginMessageLabel.setText("Username or Password doesn't match. Please try Again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }*/
}