package com.kcss.biz.appsetting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * AppSettingEntity class.
 *
 * @author X
 * @date: 2018/11/28
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
@ApiModel(value = "APP配置信息")
public class AppSettingEntity {

    @ApiModelProperty(name = "appVersion",value = "版本号")
    private String appVersion;

}
