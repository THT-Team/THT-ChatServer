import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenTest {

    @Test
    @DisplayName("테스트 토큰 생성")
    void createJWT() {
        final Date now = new Date();
        final long ACCESS_TOKEN_VALID_PERIOD =  1000L * 60 * 1;

        final Date accessTokenExpireIn = new Date(now.getTime() + ACCESS_TOKEN_VALID_PERIOD);

        String secretKey = "thtTalkAppJwtTokenSecretKeyLetsGoSuperAppSuperPowerNumberOneTalkApp";
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);

        Key jwtSecretKey = Keys.hmacShaKeyFor(keyBytes);

        final String accessToken = Jwts.builder()
            .setSubject("authorization")
            .claim("userUuid","user-uuid")
            .claim("role", "user role")
            .claim("username", "차무식")
            .setExpiration(accessTokenExpireIn)
            .signWith(jwtSecretKey, SignatureAlgorithm.HS256)
            .compact();

        System.out.println(accessToken);
    }
}
