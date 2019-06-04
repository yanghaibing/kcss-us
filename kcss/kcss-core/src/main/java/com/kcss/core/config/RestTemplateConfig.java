package com.kcss.core.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 依赖模板配置
 */
@Configuration
public class RestTemplateConfig {

    /**
     * 生成依赖模板
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(30000);
        factory.setWriteTimeout(30000);
        return new RestTemplate(factory);
    }

}
