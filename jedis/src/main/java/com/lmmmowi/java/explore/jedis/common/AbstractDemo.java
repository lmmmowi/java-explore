package com.lmmmowi.java.explore.jedis.common;

import redis.clients.jedis.Jedis;

import java.util.logging.Logger;

public abstract class AbstractDemo implements Runnable {

    protected Logger logger = Logger.getLogger(getClass().getName());

    protected Jedis jedis = new Jedis("localhost", 6379);

    public void start() {
        try {
            jedis.connect();
            this.run();
        } finally {
            jedis.disconnect();
        }
    }
}
