package com.supsi.frontend.components.selectorGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.frontend.components.plant.PlantComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SelectorCellComponent extends Component {

    @Override
    public void onAdded() {
        BorderPane cell = new BorderPane();
        cell.setMinSize(83, 81);
        PlantComponent<Rectangle> plant = (PlantComponent<Rectangle>) SelectedPlant.getInstance().getState();
        cell.setCenter(plant.getShape());
        Text text = new Text(String.valueOf(plant.getPlant().getPrice()));
        BorderPane.setAlignment(text, Pos.CENTER);
        cell.setPadding(new Insets(2,0,3,0));
        text.setFont(new Font("Comic Sans MS Bold", 14));
        cell.setBottom(text);
        cell.setBackground(new Background(new BackgroundImage(SelectorGridComponent.getCellBackground(), null, null, null, null)));
        entity.getViewComponent().addChild(cell);
    }
}
