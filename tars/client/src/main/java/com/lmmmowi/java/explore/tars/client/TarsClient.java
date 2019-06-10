package com.lmmmowi.java.explore.tars.client;

import com.lmmmowi.java.explore.tars.client.test.HelloPrx;
import com.qq.tars.client.Communicator;
import com.qq.tars.client.CommunicatorConfig;
import com.qq.tars.client.CommunicatorFactory;

/**
 * @Author: mowi
 * @Date: 2019-06-10
 * @Description:
 */
public class TarsClient {

    public static void main(String[] args) {
        CommunicatorConfig cfg = new CommunicatorConfig();

        //构建通信器
        Communicator communicator = CommunicatorFactory.getInstance().getCommunicator(cfg);

        //通过通信器，生成代理对象
        HelloPrx proxy = communicator.stringToProxy(HelloPrx.class, "Test.DemoServer.HelloObj@tcp -h 192.168.2.248 -p 12900");

        String ret = proxy.hello(1000, "Mowi");
        System.out.println("Return:" + ret);
    }
}
