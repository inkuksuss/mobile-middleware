package com.middleware.mobile.web.security;

import com.middleware.mobile.domain.dto.MemberDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@Component
public class TokenProvider {

    private static final String AUTHORITY_KEY = "authority";
    private static final String BODY = "body";

    private final String secret;
    private final long tokenValidityInMilliSeconds;

    private Key key;

    @PostConstruct
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenProvider(@Value("${jwt.secret}") String secret,
                         @Value("${jwt.token-validity-in-seconds}") long tokenValidityInMilliSeconds) {
        this.secret = secret;
        this.tokenValidityInMilliSeconds = tokenValidityInMilliSeconds * 1000;
    }

    public String createToken(MemberDto memberDto) {

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliSeconds);
        MemberDto filteredMember = MemberDto.removePassword(memberDto);

        return Jwts.builder()
                .setSubject(memberDto.getMemberEmail())
                .claim(BODY, filteredMember)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    public char getAuthority(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Map<String, Object> member = (LinkedHashMap) claims.get(BODY);
        char memberAuthority = (char) member.get("memberAuthority");
        return memberAuthority;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}

