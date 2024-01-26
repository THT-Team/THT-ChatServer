package com.example.chatserver.exception.custom;

public class FcmException extends RuntimeException {

    private static final int FCM_PUSH_LIMIT_SIZE = 500;

    public FcmException(String message) {
        super(message);
    }

    public static FcmException of(final String errorMessage) {
        return new FcmException(errorMessage);
    }

    public static FcmException overSizeException(final int transmissionSize) {
        return new FcmException(transmissionSize + "개의 송신을 시도합니다. fcm push 일괄 발송 limit size 는 " + FCM_PUSH_LIMIT_SIZE + " 입니다.");
    }
}
