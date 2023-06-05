package com.example.chatserver.stomp;

import java.time.LocalDateTime;

public record ChatResponse(
    String sender,
    String msg,
    LocalDateTime dateTime
) {

    public static ChatResponse of(final String username, final String msg) {
        return new ChatResponse(username, msg, LocalDateTime.now());
    }
}
