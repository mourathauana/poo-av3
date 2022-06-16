module com.example.av3final {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    exports app;


    opens app.controllers to javafx.fxml;
    opens app.classes to javafx.base;
}