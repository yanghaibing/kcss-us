package com.kcss.monitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import okhttp3.OkHttpClient;

@Configuration
@ComponentScan("com.kcss.monitor.*")
@EnableScheduling
@PropertySource("classpath:kcss/monitor/monitor.properties")
@PropertySource(value = "file://${CONFIG_HOME}/monitor/monitor.properties", ignoreResourceNotFound = true)
public class MonitorConfig {

    @Bean("monitorRestTemplate")
    public RestTemplate monitorRestTemplate() {
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(30000);
        factory.setWriteTimeout(30000);
        return new RestTemplate(factory);
    }

}
