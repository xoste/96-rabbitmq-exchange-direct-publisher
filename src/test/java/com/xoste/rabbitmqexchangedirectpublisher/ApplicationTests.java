package com.xoste.rabbitmqexchangedirectpublisher;

import com.xoste.rabbitmqexchangedirectpublisher.publisher.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private Publisher publisher;

    @Test
    void contextLoads() {
    }

    @Test
    void publish() throws InterruptedException {
        this.publisher.publish("发送者发送info日志消息");
    }
}
