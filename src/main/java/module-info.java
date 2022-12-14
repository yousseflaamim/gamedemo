module HangmanSkolProjekt {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    opens com.example.demo to javafx.graphics;
    exports com.example.demo;
}