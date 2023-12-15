package com.example.chatserver.entity.enums;

import com.example.chatserver.exception.custom.EnumStateNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Arrays;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Gender {

    MALE,
    FEMALE,
    BISEXUAL;

    public static Gender toConverter(final String name) {
        return Arrays.stream(Gender.values())
            .filter(gender -> gender.name().equals(name))
            .findAny()
            .orElseThrow(() -> EnumStateNotFoundException.ofGender(name));
    }

}
