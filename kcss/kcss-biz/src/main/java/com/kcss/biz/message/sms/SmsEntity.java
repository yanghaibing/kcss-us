package com.kcss.biz.message.sms;

import com.kcss.biz.message.MessageConstants;

import java.util.Date;

public class SmsEntity {

    private long id;
    private MessageConstants.MsgSender sender;
    private MessageConstants.MsgTrigger sendTrigger;
    private String sendto;
    private String code;
    private String content;
    private Status status;
    private String response;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MessageConstants.MsgSender getSender() {
        return sender;
    }

    public void setSender(MessageConstants.MsgSender sender) {
        this.sender = sender;
    }

    public MessageConstants.MsgTrigger getSendTrigger() {
        return sendTrigger;
    }

    public void setSendTrigger(MessageConstants.MsgTrigger sendTrigger) {
        this.sendTrigger = sendTrigger;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public enum Status {
        SUCCESS, FAILED, WAITING, SENDING
    }

    @Override
    public String toString() {
        return "SmsEntity{" +
                "id=" + id +
                ", sender=" + sender +
                ", sendTrigger=" + sendTrigger +
                ", sendto='" + sendto + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
