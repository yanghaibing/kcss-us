package com.kcss.rest.auth;

import com.kcss.biz.college.CollegeEntity;
import com.kcss.biz.college.CollegeService;
import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.message.MessageConstants;
import com.kcss.biz.message.sms.SmsService;
import com.kcss.biz.record.auth.AuthConstants;
import com.kcss.biz.record.auth.LoginEntity;
import com.kcss.biz.record.auth.LoginService;
import com.kcss.biz.record.auth.captcha.CheckCaptcha;
import com.kcss.biz.record.auth.token.CheckToken;
import com.kcss.biz.record.auth.token.JwtToken;
import com.kcss.core.util.common.RandomUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * LoginController class.
 *
 * @author X
 * @date: 2018/11/12
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
//@ApiIgnore
@RestController
@RequestMapping("/api/auth")
@Api(description = "授权验证")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private LoginService loginService;

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SmsService smsService;

    @GetMapping("/college")
    @ApiOperation(
            value = "获取企业或院校",
            notes = "注意：1.使用customerType 区分学生与老师;\n2.使用collegeType区分老师归属公司或院校。(若为学生不需要键入该属性)")
    public XResponse<List<CollegeEntity>> college(
            @ApiParam(name = "customerType", value = "用户类型", required = true)
            @RequestParam(value = "customerType")
                    CustomerEntity.CustomerType customerType,
            @ApiParam(name = "collegeType", value = "来源归属")
            @RequestParam(value = "collegeType", required = false)
                    CollegeEntity.CollegeType collegeType
    ) {
        return collegeService.college(customerType, collegeType);
    }

    //@CheckSmsCode
    @CheckCaptcha
    @PostMapping("/login")
    @ApiOperation(
            value = "登入",
            notes = "")
    public XResponse<LoginEntity> login(
            @ApiParam(name = "account", value = "账号", required = true)
            @RequestParam("account")
                    String account,
            @ApiParam(name = "collegeId", value = "院校或企业编号", required = true)
            @RequestParam("collegeId")
                    Long collegeId,
            @ApiParam(name = "password", value = "密码(MD5 32 lowcase)", required = true)
            @RequestParam(value = "password")
                    String password,
            @ApiParam(name = "type", value = "用户类型(学生或老师)", required = true)
            @RequestParam(value = "type")
                    CustomerEntity.CustomerType type,
            @ApiParam(name = AuthConstants.CAPTCHA_SID_HEADER, value = "获取验证码时的sid", required = false)
            @RequestHeader(value = AuthConstants.CAPTCHA_SID_HEADER, required = false)
                    String sid,
            @ApiParam(name = AuthConstants.CAPTCHA_HEADER, value = "验证码值", required = false)
            @RequestHeader(value = AuthConstants.CAPTCHA_HEADER, required = false)
                    String captcha,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台(IOS,ANDRIOD,WEBAPP)", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform) {
        return loginService.login(type, account, collegeId, password, platform);
    }

    @CheckToken
    @PostMapping("/refresh")
    @ApiOperation(
            value = "刷新token",
            notes = "")
    public XResponse<JwtToken> refresh(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform) {
        return loginService.refresh(token, platform.name());
    }

    @CheckToken
    @PostMapping("/logout")
    @ApiOperation(
            value = "登出",
            notes = "")
    public XResponse logout(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform
    ){
        return loginService.logout(token,platform.name());
    }


    @ApiIgnore
    @ApiOperation(
            value = "绑定更换手机号，发送验证码",
            notes = "")
    //@PostMapping("/bind-send-code")
    @CheckCaptcha
    @CheckToken
    public XResponse sendCode(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = AuthConstants.CAPTCHA_SID_HEADER, value = "获取验证码时的sid", required = true)
            @RequestHeader(value = AuthConstants.CAPTCHA_SID_HEADER, required = true)
                    String sid,
            @ApiParam(name = AuthConstants.CAPTCHA_HEADER, value = "验证码值", required = true)
            @RequestHeader(value = AuthConstants.CAPTCHA_HEADER, required = true)
                    String captcha,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台(IOS,ANDRIOD,WEBAPP)", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform,
            @ApiParam(name = "mobile", value = "手机号", required = true)
            @RequestParam(value = "mobile", required = true)
                    String mobile
    ){


        return loginService.sendCode(token,platform,mobile);
    }

    @ApiOperation(
            value = "绑定更换手机号,确认提交",
            notes = "")
    @CheckToken
    @PostMapping("/bind-mobile")
    public XResponse bindMobile(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台(IOS,ANDRIOD,WEBAPP)", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform,
            @ApiParam(name = "mobile", value = "手机号", required = true)
            @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "code", value = "验证码", required = true)
            @RequestParam(value = "code", required = true)
                    String code
    ){
        return loginService.bindMobile(token,platform,mobile,code);
    }


    @ApiOperation(
            value = "忘记密码，发送短信",
            notes = "")
    @PostMapping("/send-code")
    public XResponse forgetSend(
            @ApiParam(name = AuthConstants.CAPTCHA_SID_HEADER, value = "获取验证码时的sid", required = true)
            @RequestHeader(value = AuthConstants.CAPTCHA_SID_HEADER, required = true)
                    String sid,
            @ApiParam(name = AuthConstants.CAPTCHA_HEADER, value = "验证码值", required = true)
            @RequestHeader(value = AuthConstants.CAPTCHA_HEADER, required = true)
                    String captcha,
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台(IOS,ANDRIOD,WEBAPP)", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform,
            @ApiParam(name = "mobile", value = "手机号", required = true)
            @RequestParam(value = "mobile", required = true)
                    String mobile
    ){
        return loginService.forgetSend(platform,mobile);
    }


    @ApiOperation(
            value = "重置密码",
            notes = "")
    @PostMapping("/rest-password")
    public XResponse restPassword(
            @ApiParam(name = AuthConstants.PLATFORM, value = "平台(IOS,ANDRIOD,WEBAPP)", required = true)
            @RequestHeader(value = AuthConstants.PLATFORM, required = true)
                    Platform platform,
            @ApiParam(name = "mobile", value = "手机号", required = true)
            @RequestParam(value = "mobile", required = true)
                    String mobile,
            @ApiParam(name = "code", value = "验证码", required = true)
            @RequestParam(value = "code", required = true)
                    String code,
            @ApiParam(name = "password", value = "新密码 MD 32 lowcase", required = true)
            @RequestParam(value = "password", required = true)
                    String password
    ){
        return loginService.restPassword(mobile,code,password);
    }
}
