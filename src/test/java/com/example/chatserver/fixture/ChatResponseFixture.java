package com.example.chatserver.fixture;

import com.example.chatserver.stomp.ChatResponse;

import java.time.LocalDateTime;

public class ChatResponseFixture {

    private static final String chatIdx = "채팅 메세지 고유 id";
    private static final String sender = "메세지를 보낸 사람 이름";
    private static final String senderUuid = "메세지를 보낸 사람 user uuid";
    private static final String msg = "받은 메세지 내용";
    private static final String imgUrl = "받은 이미지 url";
    private static final LocalDateTime dateTime = LocalDateTime.now();

    public static ChatResponse make() {
        return new ChatResponse(chatIdx, sender, senderUuid, msg, imgUrl, dateTime);
    }
}
