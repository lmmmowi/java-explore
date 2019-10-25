package com.lmmmowi.java.explore.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lmmmowi
 * @Date: 2019/6/27
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .maximumSize(100)
                .build();

        String key = "keyA";
        System.out.println(cache.getIfPresent(key));
        cache.put(key, "valueA");
        System.out.println(cache.getIfPresent(key));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cache.getIfPresent(key));
    }
}
