package com.example.chatserver.controller;

import com.example.chatserver.facade.ChatFacade;
import com.example.chatserver.stomp.ChatRequest;
import com.example.chatserver.stomp.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatFacade chatFacade;

    @MessageMapping("/chat/{roomNo}")
    @SendTo("/sub/chat/{roomNo}")
    public ChatResponse broadcasting(final ChatRequest request,
        @DestinationVariable(value = "roomNo") final Long chatRoomNo) {

        log.info("{roomNo : {}, request : {}}", chatRoomNo, request);
        return chatFacade.doChat(request, chatRoomNo);
    }

    //만약 채팅 내용이 필요하면 @SubscribeMapping 으로
}
