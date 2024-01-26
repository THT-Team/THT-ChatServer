package com.example.chatserver.exception.custom;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntityStateException extends RuntimeException {

    public EntityStateException(final String message){ super(message);}

    public static EntityStateException doNotExistOf(final String entity) {
        return new EntityStateException("해당 겂에 해당하는 " + entity + " 가(이) 존재하지 않습니다.");
    }
}
