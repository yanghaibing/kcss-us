package com.kcss.biz.setting;

public enum SettingConfig {

    APPLICATION_IOS_VERSION("app_setting", "ios_version"),
    APPLICATION_ANDROID_VERSION("app_setting", "android_version");

    private final String namespace;
    private final String key;

    SettingConfig(String namespace, String key) {
        this.namespace = namespace;
        this.key = key;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getKey() {
        return this.key;
    }
}

