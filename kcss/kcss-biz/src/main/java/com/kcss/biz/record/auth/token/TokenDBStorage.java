package com.kcss.biz.record.auth.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenDBStorage implements TokenStorage {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public TokenEntity findToken(String token) {
        return tokenMapper.findToken(token);
    }

    @Override
    public TokenEntity findRefreshToken(String refreshToken) {
        return tokenMapper.findRefreshToken(refreshToken);
    }

    @Override
    public int create(TokenEntity token) {
        return tokenMapper.createToken(token);
    }

    @Override
    public int invalidateToken(String token) {
        return tokenMapper.invalidToken(token);
    }

    @Override
    public int invalidateRefreshToken(String refreshToken) {
        return tokenMapper.invalidRefreshToken(refreshToken);
    }

    @Override
    public int invalidate(String subject,String metaData) {
        return tokenMapper.invalidAllTokens(subject,metaData);
    }

    @Override
    public int invalidateSubject(String subject) {
        return tokenMapper.invalidateSubject(subject);
    }

}
