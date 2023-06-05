package com.example.chatserver.stomp;

public record ChatRequest(
    String sender,
    String msg
) {
}
