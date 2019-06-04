package com.kcss.biz.suggest;

import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.record.auth.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SuggestService class.
 *
 * @author X
 * @date: 2018/11/28
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Service
public class SuggestService {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private SuggestMapper suggestMapper;

    public XResponse advise(String token, Platform platform, String content) {

        CustomerEntity customer = tokenService.getCustomer(token);
        int i = suggestMapper.insertSuggest(customer.getId(),platform,content);
        return new XResponse();
    }
}
