package com.example.chatserver.entity.group;

import com.example.chatserver.entity.UserFcm;

import java.util.List;
import java.util.Objects;

public record UserFcmGroup(List<UserFcm> userFcms, String senderUuid) {

    public static UserFcmGroup of(final List<UserFcm> list, final String senderUuid) {
        return new UserFcmGroup(list, senderUuid);
    }

    public List<String> getFcmListNotInSender() {
        return this.userFcms.stream().map(UserFcm::getFirebaseToken)
                .filter(firebaseToken -> !Objects.equals(firebaseToken, senderUuid))
                .toList();
    }
}
