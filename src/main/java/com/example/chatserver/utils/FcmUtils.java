package com.example.chatserver.utils;

import com.example.chatserver.exception.custom.FcmException;
import com.google.firebase.messaging.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FcmUtils {

    private static final int FCM_PUSH_LIMIT_SIZE = 500;
    private static final long ONE_WEEK = (long) 60 * 60 * 24 * 7;
    private static final long EXPIRED_TIME_FOR_UNIX = new Date(new Date().getTime() + ONE_WEEK).getTime();

    public static void broadCast(final List<String> registrationTokens, final String senderName, final String msg, final String senderThumbnail) {

        limitSizeValidate(registrationTokens);

        MulticastMessage message = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle(senderName)
                        .setBody(msg)
                        .build())
                .putData("senderThumbnail", senderThumbnail)
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(ONE_WEEK)
                        .setNotification(AndroidNotification.builder()
                                .setIcon(senderThumbnail)
                                .build())
                        .build())
                .setApnsConfig(
                        ApnsConfig.builder()
                                .setAps(Aps.builder().build())
                                .putHeader("apns-expiration", Long.toString(EXPIRED_TIME_FOR_UNIX))
                                .build())
                .addAllTokens(registrationTokens)
                .build();

        BatchResponse response = null;

        try {
            response = FirebaseMessaging.getInstance().sendEachForMulticast(message);
        } catch (FirebaseMessagingException e) {
            log.error(String.format("sender : %s, push tokens : %s, FirebaseMessagingException : %s", senderName, registrationTokens, e.getMessage()));
        } finally {
            assert response != null;
            pushSuccessValidate(registrationTokens, response);
        }

    }

    private static void limitSizeValidate(final List<String> registrationTokens) {
        if (registrationTokens.size() > FCM_PUSH_LIMIT_SIZE) {
            throw FcmException.overSizeException(registrationTokens.size());
        }
    }

    private static void pushSuccessValidate(final List<String> registrationTokens, final BatchResponse response) {

        if (response.getSuccessCount() != registrationTokens.size()) {
            log.error(response.getFailureCount() + " message were sent failure");
        }
    }
}
