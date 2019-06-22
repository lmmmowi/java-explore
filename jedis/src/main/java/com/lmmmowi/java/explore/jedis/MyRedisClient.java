package com.lmmmowi.java.explore.jedis;

import java.io.IOException;
import java.net.Socket;

public class MyRedisClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6379);

        String key = "a";
        String value = "bbb";

        StringBuilder sb = new StringBuilder();
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("set").append("\r\n");
        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");
        sb.append("$").append(value.getBytes().length).append("\r\n");
        sb.append(value).append("\r\n");
        String msg = sb.toString();

        socket.getOutputStream().write(msg.getBytes());
        byte[] b = new byte[2048];
        socket.getInputStream().read(b);
        String resp = new String(b);
        System.out.println(resp);

        socket.close();
    }

}
