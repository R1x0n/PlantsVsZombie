package com.supsi.frontend.components.gameGrid;

import com.almasb.fxgl.entity.component.Component;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

public class GridComponent extends Component {
    public static double getCellHeight() {
        return 100;
    }

    public static double getCellWidth() {
        return 80;
    }

    @Override
    public void onAdded() {
        int columns = 9;
        int rows = 5;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                spawn("cell", entity.getX() + j * getCellWidth(), entity.getY() + i * getCellHeight());
    }
}
