package com.example.chatserver.config;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtils {

    private final String jwtSecretKey = "a";


    public String extractJwt(final StompHeaderAccessor accessor) {
        return accessor.getFirstNativeHeader("Authorization");
    }

    // todo.이거 채팅 연결 handshake 시 인증 exception 401 유효하게 반환되는지 보자
    public void validateToken(final String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecretKey).build().parseClaimsJws(token);
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new RuntimeException(String.format("exception : %s, message : 잘못된 JWT 서명입니다.", e.getClass().getName()));
        } catch (ExpiredJwtException e) {
            throw new RuntimeException(String.format("exception : %s, message : 만료된 JWT 토큰입니다.", e.getClass().getName()));
        } catch (UnsupportedJwtException e) {
            throw new RuntimeException(String.format("exception : %s, message : 지원되지 않는 JWT 토큰입니다.", e.getClass().getName()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(String.format("exception : %s, message : JWT 토큰이 잘못되었습니다.", e.getClass().getName()));
        }
        return;
    }
}
