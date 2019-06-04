package com.kcss.biz.message;

import java.util.Date;

public class MessageEntity {
    private long id;
    private long customerId;
    private long loanAppId;
    private MessageConstants.MsgTrigger trigger;
    private Status status;

    private String messageBody;

    private MessageGenerateStatus smsStatus;
    private MessageGenerateStatus appPushStatus;
    private MessageGenerateStatus appInboxStatus;

    private Date createTime;
    private Date updateTime;

    public enum Status {
        WAITING, GENERATED, DISABLED
    }

    public enum MessageGenerateStatus {
        IGNORE, TO_GENERATE, GENERATED, GENERATE_FAILED
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getLoanAppId() {
        return loanAppId;
    }

    public void setLoanAppId(long loanAppId) {
        this.loanAppId = loanAppId;
    }

    public MessageConstants.MsgTrigger getTrigger() {
        return trigger;
    }

    public void setTrigger(MessageConstants.MsgTrigger trigger) {
        this.trigger = trigger;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MessageGenerateStatus getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(MessageGenerateStatus smsStatus) {
        this.smsStatus = smsStatus;
    }

    public MessageGenerateStatus getAppPushStatus() {
        return appPushStatus;
    }

    public void setAppPushStatus(MessageGenerateStatus appPushStatus) {
        this.appPushStatus = appPushStatus;
    }

    public MessageGenerateStatus getAppInboxStatus() {
        return appInboxStatus;
    }

    public void setAppInboxStatus(MessageGenerateStatus appInboxStatus) {
        this.appInboxStatus = appInboxStatus;
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

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
