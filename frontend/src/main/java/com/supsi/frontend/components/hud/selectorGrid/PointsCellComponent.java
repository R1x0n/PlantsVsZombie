package com.supsi.frontend.components.hud.selectorGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.frontend.observers.PointsFieldObserver;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;

public class PointsCellComponent extends Component {

    @Override
    public void onAdded() {
        PointsFieldObserver pf = new PointsFieldObserver();
        BorderPane cell = new BorderPane();
        cell.setMinSize(82, 82);
        cell.setCenter(pf.getPointsField());
        cell.setBackground(new Background(new BackgroundImage(SelectorGridComponent.getCellBackground(), null, null, null, null)));
        entity.getViewComponent().addChild(cell);
    }
}
