package com.example.chatserver.config;

import com.example.chatserver.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtils {

    private final Key jwtSecretKey;

    public JwtUtils(@Value("${jwt.secret-key}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        jwtSecretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractJwt(final StompHeaderAccessor accessor) {
        return accessor.getFirstNativeHeader("Authorization");
    }

    // todo.이거 채팅 연결 handshake 시 인증 exception 401 유효하게 반환되는지 보자
    public void validateToken(final String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecretKey).build().parseClaimsJws(token);
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw UnauthorizedException.of(e.getClass().getName(),"잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            throw UnauthorizedException.of(e.getClass().getName(),"만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            throw UnauthorizedException.of(e.getClass().getName(),"지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            throw UnauthorizedException.of(e.getClass().getName(),"JWT 토큰이 잘못되었습니다.");
        }
    }
}
