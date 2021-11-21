package de.dasirgendwas.easycloud.common.database;

import com.google.gson.Gson;
import de.dasirgendwas.easycloud.common.template.Template;
import de.dasirgendwas.easycloud.common.template.TemplateGroup;
import de.dasirgendwas.easycloud.common.template.TemplateHolder;
import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicReference;

public class JedisDatabaseHandler {
    private final JedisDatabase jedisDatabase;

    public JedisDatabaseHandler(JedisDatabase jedisDatabase) {
        this.jedisDatabase = jedisDatabase;
    }

    public TemplateHolder getTemplateHolder() {
        try (Jedis jedis = this.jedisDatabase.getJedisPool().getResource()) {
            return new Gson().fromJson(jedis.get("templates"), TemplateHolder.class);
        }
    }

    public TemplateGroup getTemplateGroupByName(String name) {
        var templateGroup = new AtomicReference<TemplateGroup>(null);
        getTemplateHolder().getTemplateGroups().forEach(group -> {
            if (group.getName().equals(name)) {
                templateGroup.set(group);
            }
        });
        return templateGroup.get();
    }

    public Template getTemplateByName(String name) {
        var template = new AtomicReference<Template>(null);
        getTemplateHolder().getTemplateGroups().forEach(group -> group.getTemplates().forEach(template1 -> {
            if (template1.getName().equalsIgnoreCase(name)) {
                template.set(template1);
            }
        }));
        return template.get();
    }

    public void insertTemplateData(TemplateHolder templateHolder) {
        try (Jedis jedis = this.jedisDatabase.getJedisPool().getResource()) {
            jedis.set("templates", new Gson().toJson(templateHolder));
        }
    }

    public JedisDatabase getJedisDatabase() {
        return jedisDatabase;
    }
}

