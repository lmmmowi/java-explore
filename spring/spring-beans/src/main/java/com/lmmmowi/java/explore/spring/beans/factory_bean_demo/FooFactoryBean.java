package com.lmmmowi.java.explore.spring.beans.factory_bean_demo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: 11102942
 * @Date: 2019/6/24
 * @Description:
 */
public class FooFactoryBean implements FactoryBean<Foo> {

    @Override
    public Foo getObject() throws Exception {
        return new Foo("I am a Foo instance from FooFactoryBean");
    }

    @Override
    public Class<?> getObjectType() {
        return Foo.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
