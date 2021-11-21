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

    public Template(String name, int minMemory, int maxMemory, String icon, String displayName, int maxSlots, int minServerOnline, int maxServerOnline, TemplateType templateType, int percentToStartNewServer) {
        this.name = name;
        this.minMemory = minMemory;
        this.maxMemory = maxMemory;
        this.icon = icon;
        this.displayName = displayName;
        this.maxSlots = maxSlots;
        this.minServerOnline = minServerOnline;
        this.maxServerOnline = maxServerOnline;
        this.templateType = templateType;
        this.percentToStartNewServer = percentToStartNewServer;
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
}

