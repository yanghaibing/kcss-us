package com.kcss.biz.config;

import com.kcss.core.config.CoreConfig;
import org.springframework.boot.actuate.autoconfigure.*;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BizConfig.class, CoreConfig.class,
        EmbeddedServletContainerAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        FreeMarkerAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        JacksonAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class,
        ServerPropertiesAutoConfiguration.class,
        ValidationAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        // Actuator
        EndpointAutoConfiguration.class,
        EndpointMBeanExportAutoConfiguration.class,
        EndpointWebMvcAutoConfiguration.class,
        HealthIndicatorAutoConfiguration.class,
        IntegrationAutoConfiguration.class,
        JmxAutoConfiguration.class,
        JolokiaAutoConfiguration.class,
        ManagementServerPropertiesAutoConfiguration.class,
        MetricExportAutoConfiguration.class,
        MetricFilterAutoConfiguration.class,
        MetricRepositoryAutoConfiguration.class,
        PublicMetricsAutoConfiguration.class})
public class CommonImportConfig {
}
