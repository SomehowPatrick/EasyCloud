package de.dasirgendwas.easycloud.command;

import de.dasirgendwas.easycloud.EasyCloud;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CommandHandler {
    private final List<Command> commands;
    private final EasyCloud easyCloud;


    public CommandHandler(EasyCloud easyCloud) {
        this.commands = new ArrayList<>();
        this.easyCloud = easyCloud;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void checkCommand(String input) {
        var text = input.split(" ");
        if (text.length == 0) {
            this.easyCloud.getLogger().error("Cannot process command: " + input + " | Invalid input!");
        } else {
            var keyword = text[0];
            var found = new AtomicBoolean(false);
            this.commands.forEach(command -> {
                if (command.getName().equalsIgnoreCase(keyword)) {
                    command.execute(text);
                    found.set(true);
                }
            });
            if (!found.get()) {
                this.easyCloud.getLogger().error("Cannot process command: " + input + " | Unknown command!");
            }
        }
    }

    public List<Command> getCommands() {
        return commands;
    }
}
