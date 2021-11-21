package de.dasirgendwas.easycloud.common.demodata;

import de.dasirgendwas.easycloud.common.template.Template;
import de.dasirgendwas.easycloud.common.template.TemplateGroup;
import de.dasirgendwas.easycloud.common.template.TemplateType;

import java.util.List;

public class TemplateDemoData {

    public static Template getTemplate(String name) {
        return new Template(name,
                1,
                2,
                "Test",
                "Test",
                1,
                2,
                3,
                TemplateType.LOBBY,
                1);
    }

    public static TemplateGroup getTemplateGroup(String name) {
        return new TemplateGroup(name, "Iconus", 1, "A", "Aw", List.of(getTemplate("Tekko"), getTemplate("Test")));
    }

}
