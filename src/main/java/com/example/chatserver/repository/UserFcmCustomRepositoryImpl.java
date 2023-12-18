package com.example.chatserver.repository;

import com.example.chatserver.entity.UserFcm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFcmCustomRepositoryImpl implements UserFcmCustomRepository{


    private final JPAQueryFactory queryFactory;


    @Override
    public List<UserFcm> findAllFcmByChatRoomNo(Long chtRoomIdx) {
        return null;
    }
}
