package com.lmmmowi.java.explore.spi.springboot;

/**
 * @Author: 11102942
 * @Date: 2019/10/25
 * @Description:
 */
public class Apple implements Food {

    @Override
    public void describe() {
        System.out.println("this is an apple");
    }
}
