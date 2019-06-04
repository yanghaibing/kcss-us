package com.kcss.biz.message;

import java.util.Date;

public class MessageTemplateEntity {
    private long id;
    private MessageConstants.MsgTemplateType type;
    private MessageConstants.MsgTemplateApplication application;
    private String content;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MessageConstants.MsgTemplateType getType() {
        return type;
    }

    public void setType(MessageConstants.MsgTemplateType type) {
        this.type = type;
    }

    public MessageConstants.MsgTemplateApplication getApplication() {
        return application;
    }

    public void setApplication(MessageConstants.MsgTemplateApplication application) {
        this.application = application;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MessageTemplateEntity{" +
                "id=" + id +
                ", type=" + type +
                ", application=" + application +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
