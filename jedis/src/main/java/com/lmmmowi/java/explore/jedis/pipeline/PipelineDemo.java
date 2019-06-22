package com.lmmmowi.java.explore.jedis.pipeline;

import com.lmmmowi.java.explore.jedis.common.AbstractDemo;
import redis.clients.jedis.Pipeline;

public class PipelineDemo extends AbstractDemo {

    public static void main(String[] args) {
        new PipelineDemo().start();
    }

    @Override
    public void run() {
        this.withoutPipeline();
        this.withPipeline();
    }

    private void withoutPipeline() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            jedis.set(String.format("key_without_pipeline_%d", i), String.format("value%d", i));
        }
        logger.info(String.format("不使用pipiline耗时：%d ms", System.currentTimeMillis() - begin));
    }

    private void withPipeline() {
        Pipeline pipeline = jedis.pipelined();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            pipeline.set(String.format("key_with_pipeline_%d", i), String.format("value%d", i));
        }
        pipeline.sync();
        logger.info(String.format("使用pipiline耗时：%d ms", System.currentTimeMillis() - begin));
    }
}
