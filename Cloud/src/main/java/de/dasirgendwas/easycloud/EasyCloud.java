package de.dasirgendwas.easycloud;

import de.dasirgendwas.easycloud.command.CommandHandler;
import de.dasirgendwas.easycloud.command.commands.InfoCommand;
import de.dasirgendwas.easycloud.command.commands.StopCommand;
import de.dasirgendwas.easycloud.common.logger.Logger;
import de.dasirgendwas.easycloud.common.template.TemplateLoader;
import de.dasirgendwas.easycloud.common.template.TemplateManager;

import java.io.IOException;
import java.util.Scanner;

public class EasyCloud {
    public static final String VERSION = "0.1";

    private final String[] launchArgs;
    private final Logger logger;

    private CommandHandler commandHandler;
    private TemplateManager templateManager;

    public EasyCloud(String[] launchArgs) {
        this.launchArgs = launchArgs;
        this.logger = new Logger();
    }

    public void startCloud() throws IOException {
        this.logger.info("Starting cloud...");

        this.commandHandler = new CommandHandler(this);
        this.commandHandler.addCommand(new StopCommand("stop", "Stops the cloud", this));
        this.commandHandler.addCommand(new InfoCommand("info", "Shows information about the cloud", this));

        this.templateManager = loadTemplateManager();

        this.logger.info("Cloud started successfully!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            var input = scanner.nextLine();
            this.commandHandler.checkCommand(input);
        }
    }

    public TemplateManager loadTemplateManager() throws IOException {
        var templateLoader = new TemplateLoader();
        return templateLoader.getTemplateManager();
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
