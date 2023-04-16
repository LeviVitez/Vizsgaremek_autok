package com.example.vizsgaremek_autok;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterpasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile=new File("Images/MicrosoftTeams-image.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile=new File("Images/letöltés.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }


    public void loginButtonOnAction(ActionEvent event){
        if (usernameTextField.getText().isBlank()==false && enterpasswordField.getText().isBlank()==false){
            validateLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }



public void ExitButtonOnAction(ActionEvent event){
    Stage stage= (Stage) ExitButton.getScene().getWindow();
    stage.close();
}

public void validateLogin(){
    DatabaseConnection connectNow=new DatabaseConnection();
    Connection connectDB = connectNow.getConnection();

    String verifyLogin=""
}


}