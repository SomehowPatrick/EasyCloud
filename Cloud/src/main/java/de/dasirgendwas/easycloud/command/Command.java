package de.dasirgendwas.easycloud.command;

import de.dasirgendwas.easycloud.EasyCloud;

public abstract class Command {
    private final String name;
    private final String description;
    private final EasyCloud easyCloud;

    public Command(String name, String description, EasyCloud easyCloud) {
        this.name = name;
        this.description = description;
        this.easyCloud = easyCloud;
    }

    public abstract void execute(String[] arguments);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EasyCloud getEasyCloud() {
        return easyCloud;
    }
}
