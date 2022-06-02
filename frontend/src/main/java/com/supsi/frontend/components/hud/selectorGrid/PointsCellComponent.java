package com.supsi.frontend.components.hud.selectorGrid;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.frontend.observers.PointsFieldObserver;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class PointsCellComponent extends Component {

    private Node getTextureNode() {
        return FXGL.getAssetLoader().loadTexture("CellWood.jpg");
    }

    @Override
    public void onAdded() {
        PointsFieldObserver pf = new PointsFieldObserver();
        BorderPane cell = new BorderPane();
        cell.setViewOrder(-1);
        cell.setMinSize(82, 82);
        cell.setCenter(pf.getPointsField());
        entity.getViewComponent().addChild(cell);
        entity.getViewComponent().addChild(getTextureNode());
    }
}
