package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSocketComponent {

    private int count;

    @Autowired
    private SimpMessagingTemplate simpMessageSendingOperations; // 消息发送模板

    @Scheduled(fixedRate = 1000 * 3) // 每隔3秒向客户端发送一次数据
    public void sendMessage() {
        // 将消息推送给订阅了‘topic/getResponse’的客户端
        simpMessageSendingOperations.convertAndSend("/topic/getResponse", ++count + " - 服务端消息！");
    }
}
