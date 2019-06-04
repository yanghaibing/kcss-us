package com.kcss.harvester.config;

import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PropertyPlaceholderAutoConfiguration.class,
        JacksonAutoConfiguration.class})
public class CommonImportConfig {
}
