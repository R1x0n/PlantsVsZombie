module com.supsi.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.almasb.fxgl.all;

    requires org.controlsfx.controls;
    requires com.supsi.backend;

    exports com.supsi.frontend;
    exports com.supsi.frontend.controllers;
    opens com.supsi.frontend.controllers to javafx.fxml;
    exports com.supsi.frontend.factories;
    opens com.supsi.frontend.factories to javafx.fxml;
}
