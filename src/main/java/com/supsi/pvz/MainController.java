package com.supsi.pvz;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class MainController {

  @FXML
  public GridPane gameGrid;
	
  @FXML  
  public GridPane plantsSelector;
    
  @FXML
  public void initialize() {
    gameGrid.setGridLinesVisible(true);
    plantsSelector.setGridLinesVisible(true);
  }
}
