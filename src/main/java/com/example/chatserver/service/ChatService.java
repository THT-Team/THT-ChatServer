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

    public ChatResponse recordHistory(final Long chatRoomNo, final ChatRequest request) {

        final ChatHistory save = chatRepository.save(request.toEntity(chatRoomNo));

        return ChatResponse.of(save);
    }
}
