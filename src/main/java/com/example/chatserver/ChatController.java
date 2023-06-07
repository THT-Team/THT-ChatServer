package com.example.chatserver;

import com.example.chatserver.stomp.ChatRequest;
import com.example.chatserver.stomp.ChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/chat/{roomNo}")
    @SendTo("/sub/chat/{roomNo}")
    public ChatResponse broadcasting(final ChatRequest request,
        @DestinationVariable(value = "roomNo") final String no) {

        log.info("{roomNo : {}, request : {}}", no, request);
        return ChatResponse.of(request.sender(), request.msg());
    }

    //만약 채팅 내용이 필요하면 @SubscribeMapping 으로
}
