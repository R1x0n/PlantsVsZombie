package com.supsi.frontend.components;

import com.almasb.fxgl.entity.component.Component;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GridComponent extends Component {

    @Override
    public void onAdded() {
        var gameGrid = new GridPane();
        gameGrid.setGridLinesVisible(true);
        ColumnConstraints column = new ColumnConstraints(80);
        RowConstraints raw = new RowConstraints(100);
        for (int i = 0; i < 9; i++) {
            gameGrid.getColumnConstraints().add(column);
        }
        for(int i = 0; i < 5; i++){
            gameGrid.getRowConstraints().add(raw);
        }
        entity.getViewComponent().addChild(gameGrid);
    }
}
