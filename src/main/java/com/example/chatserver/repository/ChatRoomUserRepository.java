package com.example.chatserver.repository;

import com.example.chatserver.entity.ChatRoomUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomUserRepository extends JpaRepository<ChatRoomUser, Long> {

    List<ChatRoomUser> findAllByChatRoomIdx(final Long roomIdx);
}
