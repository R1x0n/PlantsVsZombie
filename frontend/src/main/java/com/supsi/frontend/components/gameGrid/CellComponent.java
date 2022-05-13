package com.supsi.frontend.components.gameGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.Points;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.frontend.components.plant.PlantComponent;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class CellComponent extends Component {
    private static final SelectedPlant<PlantComponent<Rectangle>> selectedPlant = SelectedPlant.getInstance();
    private final Points points = Points.getInstance();

    private void onClick(MouseEvent event) {
        var plant = selectedPlant.getState();
        if (plant != null) {
            double cellWidth = GridComponent.getCellWidth() / 2;
            double cellHeight = GridComponent.getCellHeight() / 2;
            double x = entity.getX() + cellWidth - plant.getWidth() / 2;
            double y = entity.getY() + cellHeight - plant.getHeight() / 2;
            spawn(plant.getFactoryId(), x, y);
            points.remove(plant.getPlant().getPrice());
            selectedPlant.setState(null);
        }
    }

    @Override
    public void onAdded() {
        var shape = new Rectangle(GridComponent.getCellWidth(), GridComponent.getCellHeight(), Color.TRANSPARENT);
        entity.getViewComponent().addChild(shape);
        entity.getViewComponent().addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClick);
    }
}
