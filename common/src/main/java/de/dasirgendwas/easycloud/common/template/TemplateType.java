package de.dasirgendwas.easycloud.common.template;

public enum TemplateType {
    SERVER("server"),
    LOBBY("server"),
    PROXY("proxy");

    private final String name;

    TemplateType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TemplateType{" +
                "name='" + name + '\'' +
                '}';
    }
}
