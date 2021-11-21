package de.dasirgendwas.easycloud;

import de.dasirgendwas.easycloud.command.CommandHandler;
import de.dasirgendwas.easycloud.command.commands.InfoCommand;
import de.dasirgendwas.easycloud.command.commands.StopCommand;
import de.dasirgendwas.easycloud.common.logger.Logger;

import java.util.Scanner;

public class EasyCloud {
    public static final String VERSION = "0.1";

    private final String[] launchArgs;
    private final Logger logger;

    private CommandHandler commandHandler;

    public EasyCloud(String[] launchArgs) {
        this.launchArgs = launchArgs;
        this.logger = new Logger();
    }

    public void startCloud() {
        this.logger.info("Starting cloud...");

        this.commandHandler = new CommandHandler(this);
        this.commandHandler.addCommand(new StopCommand("stop", "Stops the cloud", this));
        this.commandHandler.addCommand(new InfoCommand("info", "Shows information about the cloud", this));

        this.logger.info("Cloud started successfully!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            var input = scanner.nextLine();
            this.commandHandler.checkCommand(input);
        }
    }

    public void shutdownCloud() {
        this.logger.info("Stopping the cloud...");

        this.logger.info("Cloud stopped!");
        System.exit(0);
    }

    public String[] getLaunchArgs() {
        return this.launchArgs;
    }

    public Logger getLogger() {
        return this.logger;
    }
}
