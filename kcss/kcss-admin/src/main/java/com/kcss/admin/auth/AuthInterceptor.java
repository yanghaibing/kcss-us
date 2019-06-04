package com.kcss.admin.auth;

import com.kcss.admin.auth.session.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private final static String LOGIN_PATH = "/auth/login";
    private final static String HOME_PATH = "/index";
    private final static String AGREEMENT_PATH = "/api/contract/agreement-detail";
    private final static String AGREEMENT_TYPE_PATH = "/api/contract/agreement-detail/type";

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (null == request.getSession().getAttribute(SessionConstants.LOGIN_FLAG)) {
            if (!LOGIN_PATH.equals(uri) && !AGREEMENT_PATH.equals(uri) && !AGREEMENT_TYPE_PATH.equals(uri) && !isUnprotectedResource(uri)) {
                response.sendRedirect(LOGIN_PATH);
                return false;
            }
            return true;
        } else if (LOGIN_PATH.equals(uri)) {
            response.sendRedirect(HOME_PATH);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private boolean isUnprotectedResource(String uri) {
        if (uri.contains("favicon") || uri.startsWith("/auth/captcha")|| uri.startsWith("/api/react")
                || uri.startsWith("/contract/contract-template-detail") || uri.startsWith("/api/contract/contract-loan-detail")
                || uri.startsWith("/repayment") || uri.startsWith("/payment")
                || uri.startsWith("/bankcard") || uri.startsWith("/website")
                || uri.startsWith("/api/v1/notifications")) {
            return true;
        }

        List<String> prefixes = Arrays.asList("/js/common/", "/js/auth/", "/css/common/", "/css/auth/");
        List<String> suffixes = Arrays.asList(".js", ".css");
        boolean prefixMatch = false;
        boolean suffixMatch = false;
        for (String s : prefixes) {
            if (uri.startsWith(s)) {
                prefixMatch = true;
            }
        }
        for (String s : suffixes) {
            if (uri.endsWith(s)) {
                suffixMatch = true;
            }
        }
        return prefixMatch && suffixMatch;
    }

    private void writeMDC() {
        // TODO
    }
}
