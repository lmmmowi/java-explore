package com.lmmmowi.java.explore.jedis.qps;

import com.lmmmowi.java.explore.jedis.common.AbstractDemo;

/**
 * @Author: 11102942
 * @Date: 2019/7/15
 * @Description:
 */
public class QpsDemo extends AbstractDemo {

    public static void main(String[] args) {
        new QpsDemo().run();
    }

    @Override
    public void run() {
        jedis.set("qps_key", "hehe");

        long now = System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            jedis.get("qps_key");
        }
        System.out.println(System.currentTimeMillis() - now);

        jedis.del("qps_key");
    }
}
