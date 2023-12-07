package com.example.chatserver.repository;

import com.example.chatserver.entity.UserFcm;
import com.example.chatserver.exception.custom.EntityStateException;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFcmRepository extends JpaRepository<UserFcm, Long> {

    Optional<UserFcm> findByUserUuid(final String uuid);

    default String findFCMTokenByUuid(final String uuid) {
        return findByUserUuid(uuid).orElseThrow(
            () -> EntityStateException.doNotExistOf("UserFCM")
        ).getFirebaseToken();
    }
}
