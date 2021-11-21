package de.dasirgendwas.easycloud.common.template;

import java.util.ArrayList;
import java.util.List;

public class TemplateHolder {
    private final List<TemplateGroup> groups;

    public TemplateHolder() {
        this.groups = new ArrayList<>();
    }

    public List<TemplateGroup> getTemplateGroups() {
        return groups;
    }
}
