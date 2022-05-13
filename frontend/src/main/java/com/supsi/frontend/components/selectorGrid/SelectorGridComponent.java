package com.supsi.frontend.components.selectorGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.frontend.components.plant.AttackPlantComponent;
import com.supsi.frontend.components.plant.DefensePlantComponent;
import com.supsi.frontend.components.plant.PlantComponent;
import com.supsi.frontend.components.plant.SunflowerComponent;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class SelectorGridComponent extends Component {

    private static Image cellBackground = null;
    private final SelectedPlant<Object> selectedPlant = SelectedPlant.getInstance();
    private final Integer width = 80;
    private final Integer borderWidth = 8;

    public static Image getCellBackground() {
        if (cellBackground == null) {
            try {
                cellBackground = new Image(new FileInputStream("frontend/src/main/resources/cellWood.jpg"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cellBackground;
    }

    @Override
    public void onAdded() {

        spawn("pointCell", entity.getX() + borderWidth, entity.getY());

        List<PlantComponent<Rectangle>> plants = new ArrayList<>();
        plants.add(new SunflowerComponent());
        plants.add(new AttackPlantComponent());
        plants.add(new DefensePlantComponent());

        for(int i = 1; i < 4; i++) {
            selectedPlant.setState(plants.get(i - 1));
            spawn("selectorCell", entity.getX() + i * width, entity.getY());
        }

        selectedPlant.setState(null);
    }
}
