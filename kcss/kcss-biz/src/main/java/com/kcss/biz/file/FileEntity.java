package com.kcss.biz.file;

import com.kcss.biz.customer.CustomerEntity;
import lombok.Data;

import java.util.Date;

/**
 * FileEntity class.
 *
 * @author X
 * @date: 2018/11/16
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
public class FileEntity {

    private Long id;
    private Long uploadId;

    private FileType fileType;
    private String fileKind;
    private String path;
    private String metadata;
    private String name;
    private CustomerEntity.CustomerType uploadType;

    private Date createTime;
    private Date updateTime;

    public enum FileType {
        HEAD_PHOTO,
        HOMEWORK,
        LESSON
        ;
    }

}
