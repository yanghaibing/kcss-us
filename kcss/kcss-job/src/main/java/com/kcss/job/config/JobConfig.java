package com.kcss.job.config;

import com.kcss.biz.config.BizConfig;
import com.kcss.core.config.CoreConfig;

import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan({"com.kcss.job"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySources({
        @PropertySource(value = "classpath:kcss/job/job.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file://${CONFIG_HOME}/kcss/job/job.properties", ignoreResourceNotFound = true)
})
@EnableConfigurationProperties({com.kcss.job.config.JobProperties.class})
@Import({BizConfig.class, CoreConfig.class,
        MessageSourceAutoConfiguration.class,
        EmbeddedServletContainerAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class})
public class JobConfig {
}
