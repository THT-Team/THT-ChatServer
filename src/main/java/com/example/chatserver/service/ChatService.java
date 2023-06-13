package com.example.chatserver.service;

import com.example.chatserver.entity.ChatHistory;
import com.example.chatserver.repository.ChatRepository;
import com.example.chatserver.stomp.ChatRequest;
import com.example.chatserver.stomp.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatResponse recordHistory(final String chatRoomNo, final ChatRequest request) {

        final ChatHistory save = chatRepository.save(
            ChatHistory.of(Long.parseLong(chatRoomNo), request.sender(), request.senderUuid(),
                request.msg(), request.imgUrl())
        );

        return ChatResponse.of(save);
    }
}
