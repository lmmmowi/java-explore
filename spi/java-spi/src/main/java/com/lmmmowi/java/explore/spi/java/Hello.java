package com.lmmmowi.java.explore.spi.java;

/**
 * @Author: lmmmowi
 * @Date: 2019/10/25
 * @Description:
 */
public class Hello implements Speakable {

    @Override
    public void speak() {
        System.out.println("hello");
    }
}
