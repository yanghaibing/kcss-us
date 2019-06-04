package com.kcss.biz.record.auth.token;

import com.google.common.cache.Cache;
import com.kcss.biz.config.CacheConfig;
import com.kcss.biz.customer.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TokenService {

    private Cache<String, CustomerEntity> customerContextCache;

    @Autowired
    private CacheManager cacheManager;

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        customerContextCache = (Cache<String, CustomerEntity>) cacheManager.getCache(CacheConfig.CUSTOMER_CONTEXT_CACHE).getNativeCache();
    }

    public CustomerEntity getCustomer(String token) {
        return customerContextCache.getIfPresent(token);
    }

    public void refreshCustomer(String token,CustomerEntity customerEntity) {
        customerContextCache.invalidate(token);
        customerContextCache.put(token,customerEntity);
    }
}
