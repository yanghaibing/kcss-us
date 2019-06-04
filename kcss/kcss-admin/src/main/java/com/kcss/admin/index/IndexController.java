package com.kcss.admin.index;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    public HttpSession httpSession;

    @GetMapping(value = {"/index","/"})
    public ModelAndView index(@RequestParam(value = "locale", required = false ,defaultValue = "zh_CN") String localeStr) {
        if (!StringUtils.isEmpty(localeStr)) {
            try {
                httpSession.setAttribute("locale", LocaleUtils.toLocale(localeStr));
            } catch (Exception e) {
                logger.warn("init locale failed, use zh_CN instead");
                httpSession.setAttribute("locale", Locale.SIMPLIFIED_CHINESE);
            }
        }
        return new ModelAndView("index");
    }

}
