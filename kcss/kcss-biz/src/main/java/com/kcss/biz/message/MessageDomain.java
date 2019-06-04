package com.kcss.biz.message;

public class MessageDomain {
    private final MessageEntity messageEntity;
    private String mobile;

    public MessageDomain(MessageEntity messageEntity) {
        this.messageEntity = messageEntity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessageBody() {
        return messageEntity.getMessageBody();
    }

    public MessageConstants.MsgTrigger getTrigger() {
        return messageEntity.getTrigger();
    }

    public MessageEntity.MessageGenerateStatus getSmsStatus() {
        return messageEntity.getSmsStatus();
    }

    public MessageEntity.MessageGenerateStatus getAppPushStatus() {
        return messageEntity.getAppPushStatus();
    }

    public MessageEntity.MessageGenerateStatus getAppInboxStatus() {
        return messageEntity.getAppInboxStatus();
    }

    public long getCustomerId() {
        return messageEntity.getCustomerId();
    }

}
