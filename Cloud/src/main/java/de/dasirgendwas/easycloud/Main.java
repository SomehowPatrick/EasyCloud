package de.dasirgendwas.easycloud;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var easyCloud = new EasyCloud(args);
        easyCloud.startCloud();
    }

}
