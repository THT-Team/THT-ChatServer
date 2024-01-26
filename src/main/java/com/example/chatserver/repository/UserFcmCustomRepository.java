package com.example.chatserver.repository;

import com.example.chatserver.entity.UserFcm;
import java.util.List;

public interface UserFcmCustomRepository {

    List<UserFcm> findAllFcmByChatRoomNo(final Long chtRoomIdx);

}
