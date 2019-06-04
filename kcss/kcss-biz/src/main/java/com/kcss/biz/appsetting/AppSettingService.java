package com.kcss.biz.appsetting;

import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import com.kcss.biz.config.CacheConfig;
import com.kcss.biz.setting.SettingConfig;
import com.kcss.biz.setting.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * AppSettingService class.
 *
 * @author X
 * @date: 2018/11/28
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Service
public class AppSettingService {

    private static final Logger logger = LoggerFactory.getLogger(AppSettingService.class);

    @Autowired
    private SettingService settingService;

    @Autowired
    private CacheManager cacheManager;

    private GuavaCache appSettingCache;

    //初始化appSettingCache缓存容器
    @PostConstruct
    public void init() {
        appSettingCache = (GuavaCache) cacheManager.getCache(CacheConfig.APP_SETTING);
    }

    public XResponse<AppSettingEntity> appSetting(Platform platform) {

        //缓存中获取
        XResponse<AppSettingEntity> xResponse = new XResponse<AppSettingEntity>();
        Cache.ValueWrapper appsettingsCache = appSettingCache.get("appsetting" + platform.name());
        AppSettingEntity appSettings = null;
        if (appsettingsCache != null) {
            appSettings = (AppSettingEntity) appsettingsCache.get();
            if (appSettings != null) {
                xResponse.setData(appSettings);
                return xResponse;
            }
        }

        //db获取 并缓存
        try {
            appSettings = initAppSettingEntity(platform);
            xResponse.setData(appSettings);
            appSettingCache.put("appsetting" + platform.name(), appSettings);
            return xResponse;
        } catch (Throwable e) {
            e.printStackTrace();
            appSettings = new AppSettingEntity();
            xResponse.setData(appSettings);
            return xResponse;
        }
    }

    public AppSettingEntity initAppSettingEntity(Platform platform) {
        AppSettingEntity appSettingEntity = new AppSettingEntity();
        switch (platform) {
            case IOS:
                appSettingEntity.setAppVersion(settingService.getSettingsByConfig(SettingConfig.APPLICATION_IOS_VERSION).getValue());
                break;
            case ANDROID:
                appSettingEntity.setAppVersion(settingService.getSettingsByConfig(SettingConfig.APPLICATION_ANDROID_VERSION).getValue());
                break;
        }
        return appSettingEntity;
    }


}
