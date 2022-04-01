module com.supsi.pvz {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;

  opens com.supsi.pvz to javafx.fxml;
  exports com.supsi.pvz;
  exports com.supsi.pvz.controllers;
  opens com.supsi.pvz.controllers to javafx.fxml;
}
