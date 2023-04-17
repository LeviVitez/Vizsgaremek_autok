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

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Images/MicrosoftTeams-image.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

    }

    public void loginButtonOnAction(ActionEvent event) throws SQLException {
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

    public void validateLogin() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_data WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterpasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Succesful Login!");
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoggedIn.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 520, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Logged In");
                    stage.setScene(scene);
                    stage.show();
                } else {
                    loginMessageLabel.setText("Username or Password doesn't match. Please try Again.");
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}