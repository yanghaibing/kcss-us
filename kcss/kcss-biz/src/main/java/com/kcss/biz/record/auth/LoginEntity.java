package com.kcss.biz.record.auth;

import com.kcss.biz.record.auth.token.JwtToken;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * LoginEntity class.
 *
 * @author X
 * @date: 2018/11/20
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@ApiModel("登录")
@Data
public class LoginEntity {

    @ApiModelProperty(name = "token",value = "token令牌")
    private String token;
    @ApiModelProperty(name = "bindMobile",value = "是否绑定手机号 true：需要绑定，false：已经绑定")
    private boolean bindMobile;
}
