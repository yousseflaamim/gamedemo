module demo {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires lombok;
    opens com.example.demo to javafx.graphics;
    exports com.example.demo;
}