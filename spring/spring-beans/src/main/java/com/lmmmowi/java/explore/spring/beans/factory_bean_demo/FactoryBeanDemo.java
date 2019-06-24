package com.lmmmowi.java.explore.spring.beans.factory_bean_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: 11102942
 * @Date: 2019/6/24
 * @Description:
 */
public class FactoryBeanDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/factory-bean-demo.xml");
        Foo foo = applicationContext.getBean(Foo.class);
        foo.hello();
    }
}
