package com.example.chatserver.entity.enums.converter;

import com.example.chatserver.entity.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(final UserRole attribute) {
        if (Objects.isNull(attribute)) {
            throw new NullPointerException("Enum Converting String - UserRole is null");
        }

        return attribute.name();
    }

    @Override
    public UserRole convertToEntityAttribute(final String dbData) {
          return UserRole.toConverter(dbData);
    }
}
