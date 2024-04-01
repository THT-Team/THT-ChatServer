package com.example.chatserver.fixture;

import com.example.chatserver.stomp.ChatRequest;

public class ChatRequestFixture{
    private static final String sender = "보내는 사람 이름";
    private static final String senderUuid = "보내는 사람 user uuid";
    private static final String imgUrl = "보내는 사람 프로필 img url";
    private static final String msg = "전송 메세지 내용";

    public static ChatRequest make() {
        return new ChatRequest(sender, senderUuid, imgUrl, msg);
    }
}
