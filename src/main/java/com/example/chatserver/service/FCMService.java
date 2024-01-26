package com.example.chatserver.service;

import com.example.chatserver.entity.group.UserFcmGroup;
import com.example.chatserver.repository.UserFcmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FCMService {

    private final UserFcmRepository userFcmRepository;

    public UserFcmGroup findFcmTokenList(final Long chatRoomNo, final String senderUuid) {
        return UserFcmGroup.of(userFcmRepository.findAllFcmByChatRoomNo(chatRoomNo), senderUuid);
    }
}
