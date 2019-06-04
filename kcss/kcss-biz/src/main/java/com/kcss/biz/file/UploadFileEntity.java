package com.kcss.biz.file;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * UploadFileEntity class.
 *
 * @author X
 * @date: 2018/11/27
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
@ApiModel(value = "文件上传响应体")
public class UploadFileEntity {

    @ApiModelProperty(name = "fileUrl",value = "成功文件，访问地址")
    private List<String> fileUrls;

    @ApiModelProperty(name = "upErrFileNames",value = "失败文件名")
    private List<String> upErrFileNames;
}
