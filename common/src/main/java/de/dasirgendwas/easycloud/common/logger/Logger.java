package de.dasirgendwas.easycloud.common.logger;

public class Logger {

    private void message(String message) {
        System.out.println(message);
    }

    public void info(String info) {
        message("[INFO] " + info);
    }

    public void warn(String warn) {
        message("[WARN] " + warn);
    }

    public void error(String error) {
        message("[ERROR] " + error);
    }
}
