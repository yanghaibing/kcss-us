package com.kcss.job.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.Getter;

@Getter
@ConfigurationProperties(prefix = "job", ignoreUnknownFields = false)
public class JobProperties {

    private final Cron cron = new Cron();

    private final Setting setting = new Setting();

    @Data
    public static class Cron {
        private String demo;
    }

    @Data
    public static class Setting {
        private int corePoolSize;
        private int maxPoolSize;
        private int queueCapacity;
    }


}
