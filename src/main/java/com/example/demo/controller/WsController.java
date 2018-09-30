package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @MessageMapping("/sendMsg")
    @SendTo("/topic/getMsg") // 当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息。
    public String getMsg(String message) {
        return "msg：" + message;
    }


}
