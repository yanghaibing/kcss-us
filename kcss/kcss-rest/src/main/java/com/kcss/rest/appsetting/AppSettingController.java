package com.kcss.rest.appsetting;

import com.kcss.biz.appsetting.AppSettingEntity;
import com.kcss.biz.appsetting.AppSettingService;
import com.kcss.biz.common.Platform;
import com.kcss.biz.common.XResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * AppSettingController class.
 *
 * @author X
 * @date: 2018/11/28
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Controller
@RequestMapping("/api/app")
@Api(description = "APP信息")
public class AppSettingController {

    @Autowired
    private AppSettingService appSettingService;

    @ResponseBody
    @GetMapping("/setting")
    @ApiOperation(
            value = "APP配置信息",
            notes = "")
    public XResponse<AppSettingEntity> appSetting(
            @ApiParam(name = "platform", value = "平台", required = true)
            @RequestParam(value = "platform",required = true)
            Platform platform
    ){

        return appSettingService.appSetting(platform);
    }

}
