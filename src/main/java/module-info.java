module com.supsi.pvz {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;

  opens com.supsi.pvz to javafx.fxml;
  exports com.supsi.pvz;
}