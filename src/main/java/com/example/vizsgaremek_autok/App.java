package com.example.vizsgaremek_autok;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1021, 728);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("TeAutód.hu");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}