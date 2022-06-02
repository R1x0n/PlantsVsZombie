package com.supsi.frontend.components.hud.selectorGrid;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.observers.SelectedPlant;
import com.supsi.frontend.components.plant.AttackPlantComponent;
import com.supsi.frontend.components.plant.DefensePlantComponent;
import com.supsi.frontend.components.plant.PlantComponent;
import com.supsi.frontend.components.plant.SunflowerComponent;
import java.util.ArrayList;
import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class SelectorGridComponent extends Component {

    private final SelectedPlant<Object> selectedPlant = SelectedPlant.getInstance();

    @Override
    public void onAdded() {

        int borderWidth = 8;
        spawn("pointCell", entity.getX() + borderWidth, entity.getY());

        List<PlantComponent> plants = new ArrayList<>();
        plants.add(new SunflowerComponent());
        plants.add(new AttackPlantComponent());
        plants.add(new DefensePlantComponent());

        for(int i = 1; i < 4; i++) {
            selectedPlant.setState(plants.get(i - 1));
            int width = 80;
            spawn("selectorCell", entity.getX() + i * width, entity.getY());
        }

        selectedPlant.setState(null);
    }
}
