package com.example.chatserver.entity;

import com.example.chatserver.entity.enums.Gender;
import com.example.chatserver.entity.enums.UserRole;
import com.example.chatserver.entity.enums.converter.GenderConverter;
import com.example.chatserver.entity.enums.converter.UserRoleConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table
@NoArgsConstructor
@Getter
@ToString
@DynamicUpdate
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String userUuid;

    @Column
    private String username;

    @Column
    private LocalDate birthDay;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    @Lob
    private String introduction;

    @Column
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @Column
    @Convert(converter = GenderConverter.class)
    private Gender preferGender;

    @Column
    @Convert(converter = UserRoleConverter.class)
    private UserRole userRole;

}

