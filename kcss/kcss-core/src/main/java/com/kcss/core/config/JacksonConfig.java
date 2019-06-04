package com.kcss.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.github.miemiedev.mybatis.paginator.jackson2.PageListJsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Jackson配置
 * Jackson是一个简单基于Java应用库
 * Jackson可以轻松的将Java对象转换成json对象和xml文档
 * 同样也可以将json、xml转换成Java对象
 */
@Configuration
public class JacksonConfig {

    /**
     * 信息转换器
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        ObjectMapper om = new PageListJsonMapper();
        om.setDateFormat(new ISO8601DateFormat());
        return new MappingJackson2HttpMessageConverter(om);
    }
}
