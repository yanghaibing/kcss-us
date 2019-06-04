package com.kcss.biz.record.auth;

import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.customer.CustomerMapper;
import com.kcss.biz.message.MessageConstants;
import com.kcss.biz.message.sms.SmsService;
import com.kcss.biz.record.auth.token.*;
import com.kcss.core.exception.ErrorConstants;
import com.kcss.core.exception.RecordErrorConstants;
import com.kcss.core.util.common.MD5Util;
import com.kcss.core.util.common.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * LoginService class.
 *
 * @author X
 * @date: 2018/11/12
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Service
public class LoginService {
    private final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    public CustomerMapper customerMapper; //t_student_tacjer

    @Autowired
    public RecordAuthMapper recordAuthMapper; //鉴权

    @Autowired
    public TokenProvider tokenProvider; //token工厂

    @Autowired
    private TokenStorage tokenStorage;//token厂库

    @Autowired
    private SmsService smsService;//短信服务

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     * @param account
     * @param collegeId
     * @param password
     * @return
     */
    public XResponse<LoginEntity> login(CustomerEntity.CustomerType type,String account, Long collegeId, String password, Platform platform) {
        CustomerEntity customer = findUser(type,account,collegeId, password);
        recordAuthMapper.updateLoginSuccessById(customer.getId());
        LoginEntity loginEntity = new LoginEntity(){{
            setToken(tokenProvider.generate(""+customer.getId(),platform.name()).getToken());
            if(StringUtils.isEmpty(customer.getMobile())){
                setBindMobile(true);
            }
        }};
        return new XResponse<LoginEntity>(){{
            setData(loginEntity);
        }};
        //throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_INVALID_CAPTCHA);
    }

    /**
     *  校验用户登录信息
     * @param account
     * @param collegeId
     * @param password
     * @return
     */
    private CustomerEntity findUser(CustomerEntity.CustomerType type,String account, Long collegeId, String password){
        List<CustomerEntity> customerEntityList = customerMapper.findUser(account, collegeId,type.name());
        for(CustomerEntity customerEntity:customerEntityList){
            if(customerEntity.getPassword().equals(MD5Util.AESEncode(password))){
                if(customerEntity.getStatus()== CustomerEntity.Status.ACTIVE){
                    return customerEntity;
                }
                throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_ACCESS_DENIED);
            }
        }
        throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_INVALID_ACCOUNT_PASSWORD);
    }

    //get->invalid->generate
    public XResponse<JwtToken> refresh(String token,String platform) {
        TokenEntity rToken = tokenStorage.findToken(token);
        return new XResponse<JwtToken>(){{
            setData(tokenProvider.refreshToken(rToken.getSubject(),rToken.getRefreshToken(),platform));
        }};
    }

    public XResponse logout(String token,String platform) {
        tokenProvider.invalidTokenByLogout(token);
        return new XResponse();
    }


    public XResponse sendCode(String token, Platform platform, String mobile) {
        smsService.sendCode(MessageConstants.MsgTrigger.BIND_PHONE,mobile, MessageConstants.MsgTemplateApplication.BIND_PHONE, RandomUtil.randomSixNum());
        return new XResponse();
}

    public XResponse bindMobile(String token, Platform platform, String mobile, String code) {
        if(smsService.validateCode(mobile,code)){
            CustomerEntity customer = tokenService.getCustomer(token);
            int i = customerMapper.updateCustomerBindMobile(customer.getId(),mobile);
        }else{
            throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_INVALID_SMS_CODE);
        }
        return new XResponse();
    }

    public XResponse forgetSend(Platform platform, String mobile) {
        if(customerMapper.haveThisMobile(mobile)>0){
            smsService.sendCode(MessageConstants.MsgTrigger.BIND_PHONE,mobile, MessageConstants.MsgTemplateApplication.BIND_PHONE, RandomUtil.randomSixNum());
        }else{
            throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_NO_HAVE_MOBILE);
        }
        return new XResponse();
    }

    @Transactional
    public XResponse restPassword(String mobile, String code, String password) {

        if(smsService.validateCode(mobile,code)){
            int i = customerMapper.updateCustomerPassworByMobile(MD5Util.AESEncode(password),mobile);
            //更新密码销毁token
            tokenStorage.invalidateSubject(String.valueOf(customerMapper.findCustomerByMobile(mobile).getId()));
        }else{
            throw new RecordAuthException(RecordErrorConstants.ERR_AUTH_INVALID_SMS_CODE);
        }
        return new XResponse();
    }
}
