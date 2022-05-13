package com.supsi.frontend.components.selectorGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.Points;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.backend.observers.utils.Observer;
import com.supsi.frontend.components.plant.PlantComponent;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SelectorCellComponent extends Component implements Observer {

    private Constructor<PlantComponent<Rectangle>> plantConstructor;
    private Integer price;
    private final Points points = Points.getInstance();
    private final SelectedPlant<PlantComponent<Rectangle>> selectedPlant = SelectedPlant.getInstance();
    private Rectangle cellOverlay;

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
            PlantComponent<Rectangle> currentPlant = selectedPlant.getState();
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
                PlantComponent<Rectangle> newPlant = plantConstructor.newInstance();
                PlantComponent<Rectangle> currentPlant = selectedPlant.getState();
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
        cell.setMinSize(83, 81);
        PlantComponent<Rectangle> plant = (PlantComponent<Rectangle>) SelectedPlant.getInstance().getState();
        cell.setCenter(plant.getShape());
        price = plant.getPlant().getPrice();
        Text text = new Text(String.valueOf(plant.getPlant().getPrice()));
        try {
            plantConstructor = (Constructor<PlantComponent<Rectangle>>) plant.getClass().getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BorderPane.setAlignment(text, Pos.CENTER);
        cell.setPadding(new Insets(2,0,3,0));
        text.setFont(new Font("Comic Sans MS Bold", 14));
        cell.setBottom(text);
        cell.setBackground(new Background(new BackgroundImage(SelectorGridComponent.getCellBackground(), null, null, null, null)));
        entity.getViewComponent().addChild(cell);
        cellOverlay = new Rectangle(80, 80);
        cellOverlay.setOpacity(0);
        entity.getViewComponent().addChild(cellOverlay);
        selectedPlant.attach(this);
        entity.getViewComponent().addEventHandler(MouseEvent.MOUSE_CLICKED, this::onClick);
    }

    @Override
    public void update() {
        toggleMarking();
    }
}