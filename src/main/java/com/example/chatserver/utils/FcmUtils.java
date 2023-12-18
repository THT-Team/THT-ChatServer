package com.example.chatserver.utils;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FcmUtils {

    public static void broadCast(final String a) {
        // This registration token comes from the client FCM SDKs.
        final String registrationToken = "";

        // See documentation on defining a message payload.
        Message message = Message.builder()
            .putData("score", "850")
            .putData("time", "2:45")
            .setToken(registrationToken)
            .build();

        // Send a message to the device corresponding to the provided
        // registration token.
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            //전송 실패
            throw new RuntimeException(e);
        }

        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }
}
