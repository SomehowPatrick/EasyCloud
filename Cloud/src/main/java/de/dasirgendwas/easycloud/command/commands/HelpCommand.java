package de.dasirgendwas.easycloud.command.commands;

import de.dasirgendwas.easycloud.EasyCloud;
import de.dasirgendwas.easycloud.command.Command;

public class HelpCommand extends Command {
    public HelpCommand(String name, String description, EasyCloud easyCloud) {
        super(name, description, easyCloud);
    }

    @Override
    public void execute(String[] arguments) {
        var logger = this.getEasyCloud().getLogger();
        logger.info("Help:");
        getEasyCloud().getCommandHandler().getCommands().forEach(command -> {
            logger.info(command.getName() + " | " + command.getDescription());
        });
    }
}
