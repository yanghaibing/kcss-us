package com.kcss.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

/**
 * 核心配置
 */
@Configuration
@ComponentScan({"com.kcss"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySources({
        @PropertySource(value = "classpath:kcss/core/core.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file://${CONFIG_HOME}/kcss/core/core.properties", ignoreResourceNotFound = true)
})
public class CoreConfig {

    @Autowired
    private Environment env;    //程序运行环境

    /**
     * 国际化信息
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        //国际化信息配置文件路径
        String basenames = env.getProperty("messages.basename");
        if (StringUtils.hasText(basenames)) {
            //StringUtils.trimAllWhitespace(basenames) 从给定的{basenames}中删除所有空格
            //StringUtils.commaDelimitedListToStringArray(String str) 将逗号分隔列表转换为一个字符串数组
            //messageSource.setBasenames(String... basenames)
            messageSource.setBasenames(StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace(basenames)));
        }
        //设置默认字符编码集
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

}
