package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.others.Configs;
import com.supsi.backend.model.others.Sun;

public class SunClickedCommand implements Command {

    // reveiver
    Sun s;

    public SunClickedCommand(Sun s) {
        this.s = s;
    }

    @Override
    public void execute() {
        s.addPoints(Configs.getInstance().getPointsPerSun());
    }

    @Override
    public void undo() {
        s.addPoints(-(Configs.getInstance().getPointsPerSun()));
    }
}
