package com.kcss.biz.record.auth.token;

import com.google.common.cache.Cache;
import com.kcss.biz.config.CacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TokenLocalStorage implements TokenStorage {

    private Cache<String, TokenEntity> tokenCache;
    private Cache<String, TokenEntity> refreshCache;

    @Autowired
    private CacheManager cacheManager;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        tokenCache = (Cache<String, TokenEntity>) cacheManager.getCache(CacheConfig.TOKEN_CACHE).getNativeCache();
        refreshCache = (Cache<String, TokenEntity>) cacheManager.getCache(CacheConfig.REFRESH_TOKEN_CACHE).getNativeCache();
    }

    @Override
    public TokenEntity findToken(String token) {
        return tokenCache.getIfPresent(token);
    }

    @Override
    public TokenEntity findRefreshToken(String refreshToken) {
        return refreshCache.getIfPresent(refreshToken);
    }

    @Override
    public int create(TokenEntity token) {
        tokenCache.put(token.getToken(), token);
        refreshCache.put(token.getRefreshToken(), token);
        return 1;
    }

    @Override
    public int invalidateToken(String token) {
        tokenCache.invalidate(token);
        return 1;
    }

    @Override
    public int invalidateRefreshToken(String refreshToken) {
        refreshCache.invalidate(refreshToken);
        return 1;
    }

    @Override
    public int invalidate(String subject,String metaData) {
        // could not be done
        return 1;
    }

    @Override
    public int invalidateSubject(String subject) {
        return 0;
    }
}
