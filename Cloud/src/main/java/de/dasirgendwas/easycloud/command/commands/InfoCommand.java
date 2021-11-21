package de.dasirgendwas.easycloud.command.commands;

import de.dasirgendwas.easycloud.EasyCloud;
import de.dasirgendwas.easycloud.command.Command;

public class InfoCommand extends Command {
    public InfoCommand(String name, String description, EasyCloud easyCloud) {
        super(name, description, easyCloud);
    }

    @Override
    public void execute(String[] arguments) {
        this.getEasyCloud().getLogger().info("Information about the cloud");
        this.getEasyCloud().getLogger().info(" ");
        this.getEasyCloud().getLogger().info("Cloud Version: " + EasyCloud.VERSION);
        this.getEasyCloud().getLogger().info("OS: " + System.getProperty("os.name"));
        this.getEasyCloud().getLogger().info("Architecture: " + System.getProperty("os.arch"));
        this.getEasyCloud().getLogger().info("Version: " + System.getProperty("os.name"));
        this.getEasyCloud().getLogger().info("Allocated RAM: " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "MB");
        this.getEasyCloud().getLogger().info("Used RAM: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024) + "MB");
    }
}
