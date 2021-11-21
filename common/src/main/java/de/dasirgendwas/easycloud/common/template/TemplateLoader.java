package de.dasirgendwas.easycloud.common.template;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TemplateLoader {
    public static final String TEMPLATE_CONFIG_FILE = "templates.json";

    private final TemplateManager templateManager;

    public TemplateLoader() throws IOException {
        var templateConfig = new File(TemplateLoader.TEMPLATE_CONFIG_FILE);
        if (!templateConfig.exists()) {
            templateConfig.createNewFile();
        }
        var tmpTemplateManager = new Gson().fromJson(new FileInputStream(templateConfig).toString(), TemplateManager.class);
        this.templateManager = tmpTemplateManager != null ? tmpTemplateManager : new TemplateManager();
    }

    public TemplateManager getTemplateManager() {
        return templateManager;
    }

}
