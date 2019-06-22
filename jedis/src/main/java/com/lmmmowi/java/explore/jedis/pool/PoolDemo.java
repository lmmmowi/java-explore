package com.lmmmowi.java.explore.jedis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PoolDemo {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setTestOnBorrow(false);
        jedisPoolConfig.setTestOnCreate(true);

        // 初始化Jedis池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost", 6379);

        // 获取Jedis连接
        Jedis jedis = jedisPool.getResource();

        // 执行命令
        String value = jedis.get("a");
        System.out.println(value);

        // 归还Jedis连接
        jedis.close();

        // 关闭Jedis池
        jedisPool.close();
    }
}
