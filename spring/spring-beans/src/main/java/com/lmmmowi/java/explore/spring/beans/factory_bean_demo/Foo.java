package com.lmmmowi.java.explore.spring.beans.factory_bean_demo;

/**
 * @Author: 11102942
 * @Date: 2019/6/24
 * @Description:
 */
public class Foo {

    private String msg;

    public Foo(String msg) {
        this.msg = msg;
    }

    public void hello(){
        System.out.println(msg);
    }
}
