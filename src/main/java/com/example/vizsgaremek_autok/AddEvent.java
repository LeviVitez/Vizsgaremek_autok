package com.example.vizsgaremek_autok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AddEvent implements Initializable {
@FXML
private ImageView AddeventImageView;
@FXML
private Button megseButton;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File addeventfile = new File("Images/addevent.png");
        Image addeventimage = new Image(addeventfile.toURI().toString());
        AddeventImageView.setImage(addeventimage);
    }

    public void megseOnButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) megseButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CarDataList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 604, 622);
        Stage stage3 = new Stage();
        stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setScene(scene);
        stage3.show();
    }
}
