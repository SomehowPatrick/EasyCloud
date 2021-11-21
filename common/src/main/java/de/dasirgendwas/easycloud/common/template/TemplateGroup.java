package de.dasirgendwas.easycloud.common.template;

import java.util.List;

public class TemplateGroup {
    private String name;
    private String icon;
    private int slot;
    private String displayName;
    private String description;
    private List<Template> templates;

    public TemplateGroup(String name, String icon, int slot, String displayName, String description, List<Template> templates) {
        this.name = name;
        this.icon = icon;
        this.slot = slot;
        this.displayName = displayName;
        this.description = description;
        this.templates = templates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    @Override
    public String toString() {
        return "TemplateGroup{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", slot=" + slot +
                ", displayName='" + displayName + '\'' +
                ", description='" + description + '\'' +
                ", templates=" + templates +
                '}';
    }
}
