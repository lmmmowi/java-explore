package com.lmmmowi.java.explore.spi.springboot;

/**
 * @Author: lmmmowi
 * @Date: 2019/10/25
 * @Description:
 */
public class Apple implements Food {

    @Override
    public void describe() {
        System.out.println("this is an apple");
    }
}
