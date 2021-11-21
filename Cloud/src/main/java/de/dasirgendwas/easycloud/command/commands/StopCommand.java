package de.dasirgendwas.easycloud.command.commands;

import de.dasirgendwas.easycloud.EasyCloud;
import de.dasirgendwas.easycloud.command.Command;

import java.io.IOException;

public class StopCommand extends Command {
    public StopCommand(String name, String description, EasyCloud easyCloud) {
        super(name, description, easyCloud);
    }

    @Override
    public void execute(String[] arguments) {
        try {
            this.getEasyCloud().shutdownCloud();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
