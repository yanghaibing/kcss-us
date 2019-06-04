package com.kcss.biz.setting;
import lombok.Data;
import java.util.Date;

@Data
public class SettingEntity {
    private Long id;
    private String key;
    private String value;
    private String namespace;
    private String comments;
    private Date updateTime;
    private Date createTime;
    private boolean flag;
}
