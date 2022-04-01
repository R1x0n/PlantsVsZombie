package com.supsi.pvz.controllers;

import com.supsi.pvz.MainApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

import static java.lang.System.exit;

public class MainMenuController {

    @FXML
    public Button start;

    @FXML
    public Button exit;

    public void startGame(MouseEvent mouseEvent) throws IOException {
        MainApplication.changeScene("view/main.fxml");
    }

    public void exitGame(MouseEvent mouseEvent) {
        exit(0);
    }
}
