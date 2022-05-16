package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.others.Configs;
import com.supsi.backend.model.others.Sun;
import com.supsi.backend.observers.Points;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SunClickedCommandTest {

    Command command = new SunClickedCommand(new Sun());
    Points p = Points.getInstance();

    @BeforeEach
    public void resetPoints() {
        p.setState(0);
    }

    @Test
    public void executeTest() {
        command.execute();
        assertEquals(Configs.getInstance().getPointsPerSun(), p.getState());
    }

    @Test
    public void undoTest() {
        command.execute();
        command.undo();
        assertEquals(0, p.getState());
    }
}
