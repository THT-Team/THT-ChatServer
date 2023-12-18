package com.example.chatserver.service;

import com.example.chatserver.entity.UserFcm;
import com.example.chatserver.repository.UserFcmRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FCMService {

    private final UserFcmRepository userFcmRepository;

    public List<String> findFcmTokenList(final Long chatRoomNo) {
        return userFcmRepository.findAllFcmByChatRoomNo(chatRoomNo).stream().map(UserFcm::getFirebaseToken).toList();
    }
}
