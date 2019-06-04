package com.kcss.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.jackson2.PageListJsonMapper;
import com.google.common.base.Strings;
import com.kcss.admin.auth.AuthInterceptor;
import com.kcss.admin.auth.session.SessionConstants;
import com.kcss.biz.config.CommonImportConfig;
import com.kcss.core.util.pagination.PageBoundsResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@ComponentScan({"com.kcss.admin"})
@Configuration
@EnableScheduling
@EnableSwagger2
@Import({CommonImportConfig.class})
public class AdminConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private AuthInterceptor authInterceptor;


    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/freemarker");

        HashMap<String, Object> vars = new HashMap<>();
        vars.put("ctx", Strings.nullToEmpty(env.getProperty("kcss.admin.freemarker.context-path")));
        vars.put("commitId", Strings.nullToEmpty(env.getProperty("kcss.admin.head.commit.id")));
        configurer.setFreemarkerVariables(vars);

        return configurer;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageBoundsResolver pageBoundsResolver = new PageBoundsResolver();
        argumentResolvers.add(pageBoundsResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(SessionConstants.LOCALE);
        registry.addInterceptor(localeChangeInterceptor);
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/")
                .setCachePeriod(60 * 60)
                .resourceChain(true)
                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/")
                .setCachePeriod(60 * 60)
                .resourceChain(true)
                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
        registry.addResourceHandler("/img/**")
                .addResourceLocations("/resources/img/")
                .setCachePeriod(60 * 60);
//        registry.addResourceHandler("/favicon.ico")
//                .addResourceLocations("/resources/favicon.ico")
//                .setCachePeriod(60 * 60 * 24 * 365);
    }

    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        ObjectMapper om = new PageListJsonMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        dateFormat.setTimeZone(TimeZone.getDefault());
        om.setDateFormat(dateFormat);
        return new MappingJackson2HttpMessageConverter(om);
    }

    @Bean
    public Docket customImplementation(@Value("${kcss.admin.enable.swagger}") boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2).enable(enableSwagger);
    }

}
