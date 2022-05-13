module com.supsi.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.almasb.fxgl.all;

    requires org.controlsfx.controls;
    requires com.supsi.backend;

    exports com.supsi.frontend;

    exports com.supsi.frontend.factories.plant;
    opens com.supsi.frontend.factories.plant to javafx.fxml;

    exports com.supsi.frontend.factories.gameGrid;
    opens com.supsi.frontend.factories.gameGrid to javafx.fxml;

    exports com.supsi.frontend.factories.zombie;
    opens com.supsi.frontend.factories.zombie to javafx.fxml;

    exports com.supsi.frontend.factories.sun;
    opens com.supsi.frontend.factories.sun to javafx.fxml;

    exports com.supsi.frontend.factories.selectorGrid;
    opens com.supsi.frontend.factories.selectorGrid to javafx.fxml;

    exports com.supsi.frontend.factories.projectile;
    opens com.supsi.frontend.factories.projectile to javafx.fxml;

    exports com.supsi.frontend.observers;
    opens com.supsi.frontend.observers to javafx.fxml;
}
