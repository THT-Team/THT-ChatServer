package com.example.chatserver.stomp;

import com.example.chatserver.entity.ChatHistory;

public record ChatRequest(
    String sender,
    String senderUuid,
    String imgUrl,
    String msg
) {

    public ChatHistory toEntity(final long chatRoomNo) {
        return ChatHistory.of(chatRoomNo, sender, senderUuid, msg, imgUrl);
    }
}
