package com.example.chatserver.repository;

import com.example.chatserver.entity.ChatHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<ChatHistory, Long> {

}
