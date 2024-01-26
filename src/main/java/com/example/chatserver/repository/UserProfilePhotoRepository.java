package com.example.chatserver.repository;

import com.example.chatserver.entity.UserProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfilePhotoRepository extends JpaRepository<UserProfilePhoto, Long> {

    Optional<List<UserProfilePhoto>> findAllByUserUuid(final String userUuid);

}
