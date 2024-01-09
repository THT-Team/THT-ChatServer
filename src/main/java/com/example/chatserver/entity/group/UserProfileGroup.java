package com.example.chatserver.entity.group;

import com.example.chatserver.entity.UserProfilePhoto;

import java.util.List;

public record UserProfileGroup(List<UserProfilePhoto> photos) {

    private static final int REPRESENTATIVE_PHOTO = 1;

    public static UserProfileGroup of(final List<UserProfilePhoto> userProfilePhoto) {
        return new UserProfileGroup(userProfilePhoto);
    }

    public String getThumbnail() {
        return this.photos.stream()
                .filter(userProfilePhoto -> userProfilePhoto.getPriority() == REPRESENTATIVE_PHOTO)
                .findFirst()
                .map(UserProfilePhoto::getUrl).get();
    }

}
