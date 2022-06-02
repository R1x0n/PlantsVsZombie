package com.supsi.frontend.components.hud.selectorGrid;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.Points;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.backend.observers.utils.Observer;
import com.supsi.frontend.components.plant.PlantComponent;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SelectorCellComponent extends Component implements Observer {

    private Constructor<PlantComponent> plantConstructor;
    private Integer price;
    private final Points points = Points.getInstance();
    private final SelectedPlant<PlantComponent> selectedPlant = SelectedPlant.getInstance();
    private Rectangle cellOverlay;

    private Node getTextureNode() {
        return FXGL.getAssetLoader().loadTexture("CellWood.jpg");
    }

    private void errorAnimation() {
        FadeTransition ft = new FadeTransition(Duration.millis(100), cellOverlay);
        cellOverlay.setFill(Color.RED);
        ft.setFromValue(0);
        ft.setToValue(0.5);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();
    }

    // metodo che si occupa di evidenziare la cella selezionata
    private void toggleMarking() {
        try {
            PlantComponent currentPlant = selectedPlant.getState();
            if (currentPlant == null || !currentPlant.equals(plantConstructor.newInstance())) {
                cellOverlay.setOpacity(0);
            } else {
                cellOverlay.setFill(Color.WHITE);
                cellOverlay.setOpacity(0.1);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void onClick(MouseEvent event) {
        try {
            if (points.getState() < price) {
                errorAnimation();
            } else {

                // controllo che la pianta selezionata non sia già in SelectedPlant. In tal caso resetta lo stato
                PlantComponent newPlant = plantConstructor.newInstance();
                PlantComponent currentPlant = selectedPlant.getState();
                if (currentPlant != null && currentPlant.equals(newPlant)) {
                    newPlant = null;
                }

                selectedPlant.setState(newPlant);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAdded() {
        BorderPane cell = new BorderPane();
        cell.setViewOrder(-1);
        cell.setMinSize(83, 81);
        PlantComponent plant = (PlantComponent) SelectedPlant.getInstance().getState();
        entity.getViewComponent().addChild(plant.getTextureSelector());
        price = plant.getPlant().getPrice();
        Text text = new Text(String.valueOf(price));
        try {
            plantConstructor = (Constructor<PlantComponent>) plant.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BorderPane.setAlignment(text, Pos.CENTER);
        cell.setPadding(new Insets(2, 0, 3, 0));
        text.setFont(new Font("Comic Sans MS Bold", 14));
        cell.setBottom(text);
        entity.getViewComponent().addChild(cell);
        cellOverlay = new Rectangle(80, 80);
        cellOverlay.setViewOrder(-2);
        cellOverlay.setOpacity(0);
        entity.getViewComponent().addChild(cellOverlay);
        selectedPlant.attach(this);
        entity.getViewComponent().addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClick);
        entity.getViewComponent().addChild(getTextureNode());
    }

    @Override
    public void update() {
        toggleMarking();
    }
}