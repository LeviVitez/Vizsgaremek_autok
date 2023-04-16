package com.example.vizsgaremek_autok;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController {
@FXML
    private Button ExitButton;

public void ExitButtonOnAction(ActionEvent event){
    Stage stage= (Stage) ExitButton.getScene().getWindow();
    stage.close();
}
}