open module com.supsi.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.almasb.fxgl.all;

    requires org.controlsfx.controls;
    requires com.supsi.backend;

    exports com.supsi.frontend;

    exports com.supsi.frontend.factories.plant;

    exports com.supsi.frontend.factories.gameGrid;

    exports com.supsi.frontend.factories.zombie;

    exports com.supsi.frontend.factories.sun;

    exports com.supsi.frontend.factories.hud.selectorGrid;

    exports com.supsi.frontend.factories.lawnmower;

    exports com.supsi.frontend.factories.projectile;

    exports com.supsi.frontend.factories.hud.pauseButton;

    exports com.supsi.frontend.observers;
}