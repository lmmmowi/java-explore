package com.lmmmowi.java.explore.spi.springboot;

import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.ClassUtils;

import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2019/10/25
 * @Description:
 */
public class SpringBootSpiDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        List<Food> foods = SpringFactoriesLoader.loadFactories( Food.class, classLoader);
        foods.forEach(Food::describe);
    }
}
