package de.dasirgendwas.easycloud.command.commands;

import de.dasirgendwas.easycloud.EasyCloud;
import de.dasirgendwas.easycloud.command.Command;

public class StopCommand extends Command {
    public StopCommand(String name, String description, EasyCloud easyCloud) {
        super(name, description, easyCloud);
    }

    @Override
    public void execute(String[] arguments) {
        this.getEasyCloud().shutdownCloud();
    }
}
