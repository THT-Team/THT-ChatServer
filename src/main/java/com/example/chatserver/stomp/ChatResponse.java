package com.example.chatserver.stomp;

import com.example.chatserver.entity.ChatHistory;
import java.time.LocalDateTime;

public record ChatResponse(
    String chatIdx,
    String sender,
    String senderUuid,
    String msg,
    String imgUrl,
    LocalDateTime dateTime
) {

    public static ChatResponse of(final ChatHistory entity) {
        return new ChatResponse(
            entity.getId(),
            entity.getSenderName(),
            entity.getSenderUuid(),
            entity.getMsg(),
            entity.getImgUrl(),
            entity.getCreatedAt()
        );
    }
}
