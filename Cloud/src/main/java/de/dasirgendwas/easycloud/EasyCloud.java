package de.dasirgendwas.easycloud;

import de.dasirgendwas.easycloud.command.CommandHandler;
import de.dasirgendwas.easycloud.command.commands.HelpCommand;
import de.dasirgendwas.easycloud.command.commands.InfoCommand;
import de.dasirgendwas.easycloud.command.commands.StopCommand;
import de.dasirgendwas.easycloud.common.database.JedisDatabase;
import de.dasirgendwas.easycloud.common.database.JedisDatabaseHandler;
import de.dasirgendwas.easycloud.common.logger.Logger;
import de.dasirgendwas.easycloud.common.template.TemplateLoader;

import java.io.IOException;
import java.util.Scanner;

public class EasyCloud {
    public static final String VERSION = "0.1";

    private final String[] launchArgs;
    private final Logger logger;

    private CommandHandler commandHandler;
    private TemplateLoader templateLoader;
    private JedisDatabaseHandler jedisDatabaseHandler;

    public EasyCloud(String[] launchArgs) {
        this.launchArgs = launchArgs;
        this.logger = new Logger();
    }

    public void startCloud() throws IOException {
        this.logger.info("Starting cloud...");

        this.commandHandler = new CommandHandler(this);
        this.commandHandler.addCommand(new StopCommand("stop", "Stops the cloud", this));
        this.commandHandler.addCommand(new InfoCommand("info", "Shows information about the cloud", this));
        this.commandHandler.addCommand(new HelpCommand("help", "Shows help about the server", this));

        this.templateLoader = loadTemplateLoader();
        addShutdownHook();

        this.jedisDatabaseHandler = loadJedisDatabase("localhost", 6379);

        this.logger.info("Cloud started successfully!");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            var input = scanner.nextLine();
            this.commandHandler.checkCommand(input);
        }
    }

    private TemplateLoader loadTemplateLoader() throws IOException {
        return new TemplateLoader();
    }

    public void shutdownCloud() throws IOException {
        this.logger.info("Stopping the cloud...");

        this.logger.info("Cloud stopped!");
        System.exit(0);
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                this.templateLoader.saveTemplateData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private JedisDatabaseHandler loadJedisDatabase(String host, int port) {
        return new JedisDatabaseHandler(new JedisDatabase(host, port));
    }

    public String[] getLaunchArgs() {
        return this.launchArgs;
    }

    public Logger getLogger() {
        return this.logger;
    }


    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public TemplateLoader getTemplateLoader() {
        return templateLoader;
    }
}
