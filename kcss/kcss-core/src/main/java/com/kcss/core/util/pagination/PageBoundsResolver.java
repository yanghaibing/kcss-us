package com.kcss.core.util.pagination;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageBoundsResolver implements HandlerMethodArgumentResolver {

    private static final String PAGE = "page";
    private static final String SIZE = "size";
    private static final String OFFSET = "offset";
    private static final String LIMIT = "limit";
    private static final String SORT = "sort";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return PageBounds.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String pageStr = webRequest.getParameter(PAGE);
        String sizeStr = webRequest.getParameter(SIZE);
        String limitStr = webRequest.getParameter(LIMIT);
        String offsetStr = webRequest.getParameter(OFFSET);
        String sort = webRequest.getParameter(SORT);
        int offset = 0, limit = 20;
        if (!StringUtils.isEmpty(pageStr) && !StringUtils.isEmpty(sizeStr)) {
            limit = Integer.parseInt(sizeStr);
            offset = (Integer.parseInt(pageStr) - 1) * limit;
        } else if (!StringUtils.isEmpty(limitStr) && !StringUtils.isEmpty(offsetStr)) {
            limit = Integer.parseInt(limitStr);
            offset = Integer.parseInt(offsetStr);
        }
        limit = limit > 100 ? 100 : limit;
        return new PageBounds(offset, limit, Order.formString(sort), false);
    }
}
