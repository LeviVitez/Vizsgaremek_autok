module com.example.vizsgaremek_autok {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vizsgaremek_autok to javafx.fxml;
    exports com.example.vizsgaremek_autok;
}