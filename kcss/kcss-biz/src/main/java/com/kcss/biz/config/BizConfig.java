package com.kcss.biz.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.kcss.biz.message.MessageConstants;
import com.kcss.biz.message.sms.*;
import com.kcss.biz.record.auth.token.TokenDBStorage;
import com.kcss.biz.record.auth.token.TokenStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("com.kcss.biz")
@PropertySource(value = "classpath:kcss/biz/biz.properties", ignoreResourceNotFound = true)
@PropertySource(value = "file://${CONFIG_HOME}/kcss/biz/biz.properties", ignoreResourceNotFound = true)
public class BizConfig {

    @Autowired
    private Environment env;

    @Value("${sms.channel}")
    private String channel;

    @Bean
    public SmsSendingService smsSendingService() {
        return new ChuanglanSmsSendingService();
    }

    @Bean
    public OSS oss(@Value("${aliyun.oss.endpoint}") String endpoint,
                   @Value("${aliyun.oss.key}") String ossKey,
                   @Value("${aliyun.oss.secret}") String ossSecret) {
        return new OSSClientBuilder().build(endpoint, ossKey, ossSecret);
    }

    /**
     * Token操作使用db
     */
    @Bean
    public TokenStorage tokenStorage() {
        return new TokenDBStorage();
    }
}
