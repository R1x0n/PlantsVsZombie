module com.supsi.frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.supsi.backend;

    opens com.supsi.frontend to javafx.fxml;
    exports com.supsi.frontend;
    exports com.supsi.frontend.controllers;
    opens com.supsi.frontend.controllers to javafx.fxml;
}