package com.kcss.rest.accesslog;

import com.kcss.core.util.accesslog.AccessLogBuilder;
import com.kcss.core.util.mdc.MDCKey;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;


@Component
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    @Value("${kcss.rest.default.locale}")
    private String localeStr;

    private final Logger logger = LoggerFactory.getLogger(AccessLogInterceptor.class);

    @Autowired
    private AccessLogBuilder accessLogBuilder;
    @Autowired
    private CounterService counterService;

    private Locale locale;

    @PostConstruct
    public void init() {
        try {
            this.locale = LocaleUtils.toLocale(localeStr);
        } catch (Exception e) {
            logger.warn("init locale failed, use in_ID instead");
            this.locale = LocaleUtils.toLocale("in_ID");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getSession().setAttribute("locale", locale);
        request.setAttribute("trace-enter-time", Instant.now());
        logger.info(accessLogBuilder.buildAccessLog(request));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info(accessLogBuilder.buildResponseLog(response));
    }

}
