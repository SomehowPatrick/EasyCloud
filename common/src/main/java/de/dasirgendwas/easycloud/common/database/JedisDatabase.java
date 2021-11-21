package de.dasirgendwas.easycloud.common.database;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDatabase {
    private final String host;
    private final int port;
    private final JedisPool jedisPool;

    public JedisDatabase(String host, int port) {
        this.host = host;
        this.port = port;
        this.jedisPool = new JedisPool(new JedisPoolConfig(), host, port);
        this.jedisPool.setMaxTotal(1000);
    }

    public JedisPool getJedisPool() {
        return this.jedisPool;
    }
}
