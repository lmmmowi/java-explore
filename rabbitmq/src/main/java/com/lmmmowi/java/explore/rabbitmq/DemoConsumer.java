package com.lmmmowi.java.explore.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Author: lmmmowi
 * @Date: 2019/10/25
 * @Description:
 */
public class DemoConsumer extends DefaultConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public DemoConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        super.handleDelivery(consumerTag, envelope, properties, body);
        String msg = new String(body, StandardCharsets.UTF_8);
        logger.info(msg);
    }
}
