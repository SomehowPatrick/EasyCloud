package de.dasirgendwas.easycloud.common.template;

import java.util.ArrayList;
import java.util.List;

public class TemplateManager {
    private List<Template> templates;

    public TemplateManager() {
        this.templates = new ArrayList<>();
    }

    public List<Template> getTemplates() {
        return templates;
    }
}
