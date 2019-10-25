package com.lmmmowi.java.explore.spi.java;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: 11102942
 * @Date: 2019/10/25
 * @Description:
 */
public class JavaSpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Speakable> serviceLoader = ServiceLoader.load(Speakable.class);
        Iterator<Speakable> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Speakable speakableService = iterator.next();
            speakableService.speak();
        }
    }
}
