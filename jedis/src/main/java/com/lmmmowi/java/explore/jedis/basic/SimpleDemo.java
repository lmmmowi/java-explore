package com.lmmmowi.java.explore.jedis.basic;

import com.lmmmowi.java.explore.jedis.common.AbstractDemo;

import java.util.Set;

public class SimpleDemo extends AbstractDemo {

    public static void main(String[] args) {
        new SimpleDemo().start();
    }

    @Override
    public void run() {
        this.set();
        this.keys();
        this.get();
        this.del();
        this.keys();
    }

    private void set() {
        logger.info("redis set");
        jedis.set("demokey", "demovalue");
    }

    private void keys() {
        logger.info("list keys");
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    private void get() {
        logger.info("redis get");
        String value = jedis.get("demokey");
        System.out.println(value);
    }

    private void del() {
        logger.info("redis del");
        jedis.del("demokey");
    }
}
