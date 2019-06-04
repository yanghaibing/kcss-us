package com.kcss.rest.customer;

import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.record.auth.AuthConstants;
import com.kcss.biz.customer.CustomerService;
import com.kcss.biz.record.auth.token.CheckToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * CustomerController class.
 *
 * @author X
 * @date: 2018/11/29
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@RestController
@RequestMapping("/api/customer")
@Api(description = "用户管理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(
            value = "获取个人信息",
            notes = ""
    )
    @CheckToken
    @GetMapping("/info")
    public XResponse<CustomerEntity> info(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token
    ){
        return customerService.info(token);
    }


    @ApiOperation(
            value = "修改个人信息",
            notes = ""
    )
    @CheckToken
    @PostMapping("/update")
    public XResponse update(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = "headerUrl", value = "headerUrl", required = true)
            @RequestParam(value = "headerUrl",required = true)
            String headerUrl
    ){

        return customerService.update(token,headerUrl);
    }

}
