package com.kcss.biz.customer;

import lombok.Data;

import java.util.Date;

/**
 * CustomerEntity class.
 *
 * @author X
 * @date: 2018/11/12
 * Todo: 基本信息 参考 t_student_teacher
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Data
public class CustomerEntity {

    private Long id;

    private Long collegeId;

    private CustomerType type;

    private String markNo;

    private String password;

    private String name;

    private String nickName;

    private String mobile;

    private String email;

    private String headFileId;

    private String headUrl;

    private Status status;

    private Integer failedLoginCount;

    private Date statusExpiredTime;

    private Date lastLoginTime;

    private Date createTime;

    private Date updateTime;

    public enum CustomerType{
        STUDENT,
        TEACHER
    }

    public enum Status{
        ACTIVE,
        INACTIVE
    }

}
