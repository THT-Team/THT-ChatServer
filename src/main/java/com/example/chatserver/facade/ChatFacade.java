package com.example.chatserver.facade;

import com.example.chatserver.service.ChatService;
import com.example.chatserver.service.FCMService;
import com.example.chatserver.stomp.ChatRequest;
import com.example.chatserver.stomp.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatFacade {

    private final ChatService chatService;
    private final FCMService fcmService;

    public ChatResponse doChat(ChatRequest request, Long chatRoomNo) {

        //해당 방에 존재하는 모든 유저의 토큰을 찾았음
        fcmService.findFcmTokenList(chatRoomNo);

        //
        return chatService.recordHistory(chatRoomNo, request);
    }
}
