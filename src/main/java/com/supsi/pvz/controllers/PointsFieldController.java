package com.supsi.pvz.controllers;

import com.supsi.pvz.observers.Points;
import com.supsi.pvz.observers.utils.Observer;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PointsFieldController implements Observer {
  private static final Points points = Points.getInstance();

  @FXML
  public Text pointsField;

  @FXML
  public void initialize() {
    points.attach(this);
    pointsField.setText(String.valueOf(points.getState()));
  }

  @Override
  public void update() {
    pointsField.setText(String.valueOf(points.getState()));
  }
}
