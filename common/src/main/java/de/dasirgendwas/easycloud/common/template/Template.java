package de.dasirgendwas.easycloud.common.template;

public class Template {
    private String name;
    private int minMemory;
    private int maxMemory;
    private String icon;
    private String displayName;
    private int maxSlots;
    private int minServerOnline;
    private int maxServerOnline;
    private TemplateType templateType;
    private int percentToStartNewServer;

    public Template(String name) {
        this.name = name;
        this.minMemory = 0;
        this.maxMemory = 0;
        this.icon = "";
        this.displayName = "";
        this.maxSlots = 0;
        this.minServerOnline = 0;
        this.maxServerOnline = 0;
        this.templateType = null;
        this.percentToStartNewServer = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinMemory() {
        return minMemory;
    }

    public void setMinMemory(int minMemory) {
        this.minMemory = minMemory;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public int getMinServerOnline() {
        return minServerOnline;
    }

    public void setMinServerOnline(int minServerOnline) {
        this.minServerOnline = minServerOnline;
    }

    public int getMaxServerOnline() {
        return maxServerOnline;
    }

    public void setMaxServerOnline(int maxServerOnline) {
        this.maxServerOnline = maxServerOnline;
    }

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }

    public int getPercentToStartNewServer() {
        return percentToStartNewServer;
    }

    public void setPercentToStartNewServer(int percentToStartNewServer) {
        this.percentToStartNewServer = percentToStartNewServer;
    }

    @Override
    public String toString() {
        return "Template{" +
                "name='" + name + '\'' +
                ", minMemory=" + minMemory +
                ", maxMemory=" + maxMemory +
                ", icon='" + icon + '\'' +
                ", displayName='" + displayName + '\'' +
                ", maxSlots=" + maxSlots +
                ", minServerOnline=" + minServerOnline +
                ", maxServerOnline=" + maxServerOnline +
                ", templateType=" + templateType +
                ", percentToStartNewServer=" + percentToStartNewServer +
                '}';
    }
}

