package com.supsi.pvz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainApplication extends Application {

  private static final String windowTitle = "PvZ";
  private static final ResourceBundle rscBundle = ResourceBundle.getBundle("i18n/strings");

  @Override
  public void start(Stage stage) throws IOException {
    Locale.setDefault(Locale.ENGLISH);
    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("view/main-menu.fxml"), rscBundle);
    Scene scene = new Scene(fxmlLoader.load(), 800, 600);
    stage.setTitle(windowTitle);
    stage.setScene(scene);
    stage.show();
  }

  public static void changeScene(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml), rscBundle);
    Stage stage = (Stage)Window.getWindows().get(0);
    Scene scene = new Scene(fxmlLoader.load(), stage.getScene().getWidth(), stage.getScene().getHeight());
    stage.setTitle(windowTitle);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
