package com.kcss.harvester.message;

import java.io.Serializable;

public class IncomeMessage implements Serializable {

    private long id;
    private String imei;
    private String mobile;
    private long timestamp;
    private String messageType;
    private String messageBody;

    public IncomeMessage(String imei, String mobile, long timestamp, String messageType, String messageBody) {
        this.imei = imei;
        this.mobile = mobile;
        this.timestamp = timestamp;
        this.messageType = messageType;
        this.messageBody = messageBody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "IncomeMessage{" +
                "id=" + id +
                ", imei='" + imei + '\'' +
                ", mobile='" + mobile + '\'' +
                ", timestamp=" + timestamp +
                ", messageType='" + messageType + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
