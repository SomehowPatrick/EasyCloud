package de.dasirgendwas.easycloud.common.template;

import com.google.gson.Gson;

import java.io.*;

public class TemplateLoader {
    public static final String CONFIG_DIRECTORY = "./config/";
    public static final String TEMPLATE_CONFIG_FILE = CONFIG_DIRECTORY + "templates.json";

    private final TemplateHolder templateHolder;

    public TemplateLoader() throws IOException {
        var templateConfig = new File(TemplateLoader.TEMPLATE_CONFIG_FILE);
        var configDir = new File(TemplateLoader.CONFIG_DIRECTORY);
        if (!configDir.exists()) {
            configDir.mkdir();
        }
        if (!templateConfig.exists()) {
           templateConfig.createNewFile();
        }
        var text = new FileInputStream(templateConfig).toString();
        TemplateHolder templateManager;
        //if (JsonUtils.isValidJson(text, TemplateHolder.class)) {
            templateManager = new Gson().fromJson(new FileReader(templateConfig), TemplateHolder.class);
        //} else {
        //    templateManager = new TemplateHolder();
        //}
        System.out.println(templateManager.getTemplateGroups().isEmpty());
        this.templateHolder = templateManager;
    }

    public void saveTemplateData() throws IOException {
        String json = new Gson().toJson(this.templateHolder);
        var templateConfig = new File(TemplateLoader.TEMPLATE_CONFIG_FILE);
        if (!templateConfig.exists()) {
            templateConfig.createNewFile();
        }
        var printWriter = new PrintWriter(new FileOutputStream(templateConfig));
        printWriter.write(json);
        printWriter.close();
    }

    public TemplateHolder getTemplateHolder() {
        return templateHolder;
    }

}
