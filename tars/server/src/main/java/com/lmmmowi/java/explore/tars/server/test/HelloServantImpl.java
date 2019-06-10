package com.lmmmowi.java.explore.tars.server.test;

/**
 * @Author: mowi
 * @Date: 2019-06-10
 * @Description:
 */
public class HelloServantImpl implements HelloServant {

    @Override
    public String hello(int no, String name) {
        return String.format("hello no=%s, name=%s, time=%s", no, name, System.currentTimeMillis());
    }
}
