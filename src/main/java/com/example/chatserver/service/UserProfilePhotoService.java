package com.example.chatserver.service;

import com.example.chatserver.entity.group.UserProfileGroup;
import com.example.chatserver.exception.custom.EntityStateException;
import com.example.chatserver.repository.UserProfilePhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserProfilePhotoService {

    private final UserProfilePhotoRepository repository;

    public UserProfileGroup findByUuid(final String userUuid) {

        return UserProfileGroup.of(repository.findAllByUserUuid(userUuid).orElseThrow(
                () -> new EntityStateException("UserProfilePhoto")
        ));
    }

}
