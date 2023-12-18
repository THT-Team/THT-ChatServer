package com.example.chatserver.repository;

import com.example.chatserver.entity.UserFcm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFcmRepository extends JpaRepository<UserFcm, Long>, UserFcmCustomRepository {
}
