package com.kcss.core.util.common;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IPFetcher {
    private static final String FORWARDED_FOR_HEADER = "X-Forwarded-For";

    public static String getIPAddress(HttpServletRequest request) {
        String userAddress = StringUtils.isEmpty(request.getHeader(FORWARDED_FOR_HEADER)) ?
                request.getRemoteHost() :
                request.getHeader(FORWARDED_FOR_HEADER);

        if (StringUtils.hasText(userAddress) && userAddress.indexOf(',') > 0) {
            userAddress = userAddress.substring(0, userAddress.indexOf(','));
        }

        return userAddress;
    }
}
