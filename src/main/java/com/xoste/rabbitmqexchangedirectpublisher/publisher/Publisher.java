package com.xoste.rabbitmqexchangedirectpublisher.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Leon
 */
@Component
public class Publisher {
    @Autowired
    private AmqpTemplate rabbitmqAmqpTemplate;
    /**
     * 交换器名称
     * */
    @Value("${rabbitmq.config.exchange}")
    private String exchange;
    /**
     * 路由键
     * */
    @Value("${rabbitmq.config.queue.info.routing.key}")
    private String routingkey;
    public void publish(String msg) throws InterruptedException {
        /**
         * 向消息队列发送消息
         * 参数一：交换器名称   参数二：路由键  参数三：消息内容
         * */
        while (true) {
            Thread.sleep(1000);
            this.rabbitmqAmqpTemplate.convertAndSend(this.exchange, this.routingkey, msg);
        }
    }
}
