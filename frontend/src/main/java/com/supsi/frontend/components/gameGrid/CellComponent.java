package com.supsi.frontend.components.gameGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.Points;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.frontend.components.hud.selectorGrid.SelectorCellComponent;
import com.supsi.backend.observers.utils.Observer;
import com.supsi.frontend.components.plant.PlantComponent;

import com.supsi.frontend.factories.hud.selectorGrid.SelectorGridTypes;
import javafx.animation.FadeTransition;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class CellComponent extends Component implements Observer {
    private static final SelectedPlant<PlantComponent> selectedPlant = SelectedPlant.getInstance();
    private final Points points = Points.getInstance();
    private Rectangle shape;
    private Point2D cellCenter;
    private FadeTransition ft;

    private void onClick(MouseEvent event) {
        var plant = selectedPlant.getState();
        if (plant != null && getGameWorld().getEntitiesAt(cellCenter).size() == 0) {
            spawn(plant.getFactoryId(), cellCenter.getX(), cellCenter.getY());
            points.remove(plant.getPlant().getPrice());
            selectedPlant.setState(null);
            SelectorCellComponent cell = getGameWorld().getEntitiesByType(SelectorGridTypes.SELECTORCELL)
                    .stream()
                    .map((entity) -> entity.getComponent(SelectorCellComponent.class))
                    .filter((component) -> component.getCellPlant().equals(plant)).findFirst().orElse(null);
            if(cell != null) {
                cell.rechargeCell(plant.getPlant().getRechargeTime());
            }
        }
    }

    @Override
    public void onAdded() {
        var plant = selectedPlant.getState();
        double cellWidth = GridComponent.getCellWidth() / 2;
        double cellHeight = GridComponent.getCellHeight() / 2;
        cellCenter = new Point2D(entity.getX() + cellWidth - plant.getWidth() / 2, entity.getY() + cellHeight - plant.getHeight() / 2);
        shape = new Rectangle(GridComponent.getCellWidth(), GridComponent.getCellHeight(), Color.WHITE);
        shape.setOpacity(0);
        configureFadeTransition();
        selectedPlant.attach(this);
        entity.getViewComponent().addChild(shape);
        entity.getViewComponent().addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClick);
    }

    @Override
    public void update() {
        if (selectedPlant.getState() != null && getGameWorld().getEntitiesAt(cellCenter).size() == 0) {
            shape.setFill(Color.WHITE);
            ft.play();
        } else {
            shape.setOpacity(0);
            ft.stop();
        }
    }

    private void configureFadeTransition() {
        ft = new FadeTransition(Duration.millis(1000), shape);
        ft.setFromValue(0);
        ft.setToValue(0.1);
        ft.setCycleCount(Integer.MAX_VALUE);
        ft.setAutoReverse(true);
    }
}
