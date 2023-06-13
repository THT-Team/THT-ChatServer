package com.example.chatserver.entity;

import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Document(collection = "chat_history")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class ChatHistory {

    @Id
    private String id;

    @Field("room_idx")
    private Long roomIdx;

    @Field("sender_name")
    private String senderName;

    @Field("sender_uuid")
    private String senderUuid;

    @Field("msg")
    private String msg;

    @Field("img_url")
    private String imgUrl;

    @Field("created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Field("updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    private ChatHistory(String id, Long roomIdx, String senderName, String senderUuid, String msg,
        String imgUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.id = id;
        this.roomIdx = roomIdx;
        this.senderName = senderName;
        this.senderUuid = senderUuid;
        this.msg = msg;
        this.imgUrl = imgUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ChatHistory of(long roomIdx, String senderName, String senderUuid, String msg,
        String imgUrl) {

        return ChatHistory.builder()
            .roomIdx(roomIdx)
            .senderName(senderName)
            .senderUuid(senderUuid)
            .msg(msg)
            .imgUrl(imgUrl)
            .build();
    }

}
