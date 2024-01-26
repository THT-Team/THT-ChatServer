package com.example.chatserver.facade;

import com.example.chatserver.service.ChatService;
import com.example.chatserver.service.FCMService;
import com.example.chatserver.entity.group.UserFcmGroup;
import com.example.chatserver.service.UserProfilePhotoService;
import com.example.chatserver.stomp.ChatRequest;
import com.example.chatserver.stomp.ChatResponse;
import com.example.chatserver.utils.FcmUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatFacade {

    private final ChatService chatService;
    private final FCMService fcmService;
    private final UserProfilePhotoService userProfilePhotoService;

    public ChatResponse doChat(ChatRequest request, Long chatRoomNo) {

        final UserFcmGroup fcmGroup = fcmService.findFcmTokenList(chatRoomNo, request.senderUuid());
        final String senderThumbnail = userProfilePhotoService.findByUuid(request.senderUuid()).getThumbnail();

        FcmUtils.broadCast(fcmGroup.getFcmListNotInSender(), request.sender(), request.msg(), senderThumbnail);

        return chatService.recordHistory(chatRoomNo, request);
    }
}
