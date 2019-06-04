package com.kcss.core.util.messageresource;

import org.apache.commons.lang3.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Component
public class MessageHelper {

    private final Logger logger = LoggerFactory.getLogger(MessageHelper.class);

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;

    public String getMessage(String code) {
        return getMessage(code, "unspecified message");
    }

    public String getMessage(String code, String defaultMessage) {
        return getMessage(code, new String[]{}, defaultMessage);
    }

    public String getMessage(String code, List<String> params) {
        return getMessage(code, params.toArray(new String[0]), "unspecified message");
    }

    public String getMessage(String code, List<String> params, Locale locale) {
        return getMessage(code, params.toArray(new String[0]), "unspecified message", locale);
    }

    public String getMessage(String code, String[] args, String defaultMessage) {
        return getMessage(code, args, defaultMessage, getCurrentLocale());
    }

    public String getMessage(String code, String defaultMessage, Locale locale) {
        return getMessage(code, new String[]{}, defaultMessage, locale);
    }

    public String getMessage(String code, String[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    public Locale getCurrentLocale() {
        try {
            Locale locale = (Locale) session.getAttribute("locale");
            if (locale == null) {
                logger.warn("init locale failed, use zh_CN instead");
                return LocaleUtils.toLocale("zh_CN");
            }
            return locale;
        } catch (Exception e) {
            logger.warn("init locale failed, use zh_CN instead");
            return LocaleUtils.toLocale("zh_CN");
        }
    }

}
