package com.kcss.biz.college;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * CollegeEntity class.
 *
 * @author X
 * @date: 2018/11/15
 * Todo: t_college
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
@ApiModel(value = "院校或公司信息")
public class CollegeEntity {

    @ApiModelProperty(name = "id",value = "id")
    private Long id;

    @ApiModelProperty(name = "name",value = "名称")
    private String name;

    @ApiModelProperty(name = "description",value = "描述")
    private String description;

    @ApiModelProperty(name = "url",value = "官网地址")
    private String url;

    @ApiModelProperty(name = "type",value = "类别")
    private CollegeType type;

    private Status status;

    @ApiModelProperty(hidden = true)
    private Date createTime;

    @ApiModelProperty(hidden = true)
    private Date updateTime;

    public enum CollegeType{
        COLLEGE,
        COMPANY
    }

    public enum Status{
        ACTIVE,
        INACTIVE
    }

}
