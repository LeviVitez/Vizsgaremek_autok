package com.example.vizsgaremek_autok;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

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
    private ImageView lockImageView;


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
        loginMessageLabel.setText("You try to login");
    }



public void ExitButtonOnAction(ActionEvent event){
    Stage stage= (Stage) ExitButton.getScene().getWindow();
    stage.close();
}
}