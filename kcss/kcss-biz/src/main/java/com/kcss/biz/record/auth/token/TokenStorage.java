package com.kcss.biz.record.auth.token;

import org.springframework.stereotype.Service;

@Service
public interface TokenStorage {

    TokenEntity findToken(String token);

    TokenEntity findRefreshToken(String refreshToken);

    int create(TokenEntity token);

    int invalidateToken(String token);

    int invalidateRefreshToken(String refreshToken);

    int invalidate(String subject,String metaData);

    int invalidateSubject(String subject);

}
