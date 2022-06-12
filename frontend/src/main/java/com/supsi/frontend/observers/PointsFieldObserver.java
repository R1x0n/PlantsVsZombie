package com.supsi.frontend.observers;

import com.supsi.backend.observers.Points;
import com.supsi.backend.observers.utils.Observer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.List;


public class PointsFieldObserver implements Observer {
  private static final Points points = Points.getInstance();

  public Text pointsField = new Text();

  public PointsFieldObserver() {
    points.attach(this);
    pointsField.setText(String.valueOf(points.getState()));
    pointsField.setFont(new Font("Comic Sans MS Bold", 20));
  }

  public Text getPointsField() {
    return pointsField;
  }

  @Override
  public void update() {
    pointsField.setText(String.valueOf(points.getState()));
  }
}
