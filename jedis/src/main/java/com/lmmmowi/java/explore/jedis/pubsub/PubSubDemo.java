package com.lmmmowi.java.explore.jedis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

/**
 * @Author: lmmmowi
 * @Date: 2019/7/15
 * @Description:
 */
public class PubSubDemo {

    public static final String CHANNEL = "testChannel";

    private JedisPool jedisPool;

    public static void main(String[] args) {
        new PubSubDemo().run();
    }

    public void run() {
        this.jedisPool = this.createPool();

        this.startSubscriber();

        Jedis jedis = jedisPool.getResource();
        while (true) {
            jedis.publish(CHANNEL, "message " + System.currentTimeMillis());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    private JedisPool createPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnCreate(true);

        // 初始化Jedis池
        return new JedisPool(jedisPoolConfig, "localhost", 6379);
    }

    private void startSubscriber() {
        for (int i = 0; i < 3; i++) {
            new Thread(new Subscriber("subscriber" + i)).start();
        }
    }

    private class Subscriber extends JedisPubSub implements Runnable {

        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Jedis jedis = jedisPool.getResource();
            jedis.subscribe(this, CHANNEL);
        }

        @Override
        public void onMessage(String channel, String message) {
            super.onMessage(channel, message);
            System.out.println(name + " receive ==> " + message);
        }
    }
}
