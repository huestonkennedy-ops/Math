module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens application.ui to javafx.fxml;
    exports application.ui;
}
