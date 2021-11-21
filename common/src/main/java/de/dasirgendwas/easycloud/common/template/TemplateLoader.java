package de.dasirgendwas.easycloud.common.template;

import com.google.gson.Gson;
import de.dasirgendwas.easycloud.common.utils.JsonUtils;

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
        var text = new FileInputStream(templateConfig).toString();
        TemplateManager templateManager;
        if (JsonUtils.isValidJson(text, TemplateManager.class)) {
            templateManager = new Gson().fromJson(new FileInputStream(templateConfig).toString(), TemplateManager.class);
        } else {
            templateManager = new TemplateManager();
        }
        this.templateManager = templateManager;
    }

    public TemplateManager getTemplateManager() {
        return templateManager;
    }

}
