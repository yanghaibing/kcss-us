package com.kcss.biz.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * XResponse class.
 *
 * @author X
 * @date: 2018/11/13
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
@ApiModel(value = "返回类")
public class XResponse<T extends Object> {
    @ApiModelProperty(name = "code",value = "code")
    @JsonProperty("code")
    private Integer code;
    @ApiModelProperty(name = "message",value = "文本描述")
    @JsonProperty("message")
    private String message;
    @ApiModelProperty(name = "data",value = "数据体")
    @JsonProperty("data")
    private T data;

    private static final String SUCCMESS = "success";
    private static final Integer SUCCCODE = 0;

    public XResponse(){
        this.code = SUCCCODE;
        this.message = SUCCMESS;
    }
}
