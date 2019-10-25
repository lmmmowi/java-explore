package com.lmmmowi.java.explore.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: lmmmowi
 * @Date: 2019/10/25
 * @Description:
 */
public class Demo {

    private static final String QUEUE_NAME = "test_queue";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        new Demo().run();
    }

    public void run() {
        Connection connection = this.getConnection();
        this.publish(connection, "Hello World");
        this.consume(connection);
        this.closeConnection(connection);
    }

    private void publish(Connection connection, String message) {
        try (Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            logger.info("发布了消息");
        } catch (IOException | TimeoutException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void consume(Connection connection) {
        try (Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            Consumer consumer = new DemoConsumer(channel);
            channel.basicConsume(QUEUE_NAME, false, consumer);
        } catch (IOException | TimeoutException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private Connection getConnection() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        try {
            return connectionFactory.newConnection();
        } catch (IOException | TimeoutException e) {
            throw new IllegalStateException("fail to build a rabbitmq connection", e);
        }
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
