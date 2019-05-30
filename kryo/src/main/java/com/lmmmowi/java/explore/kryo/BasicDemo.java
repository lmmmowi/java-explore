package com.lmmmowi.java.explore.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * @Author: mowi
 * @Date: 2019-05-29
 * @Description:
 */
public class BasicDemo {

    public static void main(String[] args) throws Exception {
        new BasicDemo().run();
    }

    private void run() {
        Kryo kryo = new Kryo();

        Foo foo = new Foo();
        foo.setName("test");

        // 序列化
        byte[] b = this.writeObject(kryo, foo);
        System.out.println(new String(Base64.getEncoder().encode(b)));

        // 反序列化
        Foo foo2 = this.readObject(kryo, b);
        System.out.println(foo2.getName());
    }

    private byte[] writeObject(Kryo kryo, Foo foo) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output output = new Output(baos);
        kryo.writeObject(output, foo);
        output.close();
        return baos.toByteArray();
    }

    private Foo readObject(Kryo kryo, byte[] bytes) {
        Input input = new Input(bytes);
        return kryo.readObject(input, Foo.class);
    }
}
