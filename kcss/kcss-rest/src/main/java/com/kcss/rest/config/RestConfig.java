package com.kcss.rest.config;

import com.kcss.biz.config.CommonImportConfig;
import com.kcss.core.util.pagination.PageBoundsResolver;
import com.kcss.rest.accesslog.AccessLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Locale;

@Configuration
@ComponentScan({"com.kcss.rest"})
@EnableSwagger2
@Import({CommonImportConfig.class})
public class RestConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AccessLogInterceptor auditInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageBoundsResolver pageBoundsResolver = new PageBoundsResolver();
        argumentResolvers.add(pageBoundsResolver);
    }

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.CHINESE);
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor).addPathPatterns("/**");

    }
    @Bean
    public Docket customImplementation(@Value("${kcss.rest.enable.swagger}") boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2).enable(enableSwagger);
    }

    /*@Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }*/

}
