package com.kcss.monitor.entity;

import com.kcss.monitor.spec.AlertMessageType;

import java.time.Instant;

public class AlertMessageEntity {
    private String name;
    private Instant startTime;
    private Instant endTime;
    private String traceKey;
    private String traceMobile;
    private Long timeSpent;
    private AlertMessageType type;
    private String message;
    private Integer statusCode;
    private String sourceIp;
    public String getName() {
        return name;
    }

    public AlertMessageEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public AlertMessageEntity setStartTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public AlertMessageEntity setEndTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getTraceKey() {
        return traceKey;
    }

    public AlertMessageEntity setTraceKey(String traceKey) {
        this.traceKey = traceKey;
        return this;
    }

    public String getTraceMobile() {
        return traceMobile;
    }


    public AlertMessageEntity setTraceMobile(String traceMobile) {
        this.traceMobile = traceMobile;

        return this;
    }


    public Long getTimeSpent() {
        return timeSpent;
    }

    public AlertMessageEntity setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
        return this;
    }

    public AlertMessageType getType() {
        return type;
    }

    public AlertMessageEntity setType(AlertMessageType type) {
        this.type = type;
        return this;
    }

    public String getMessage() {
        return message;
    }


    public AlertMessageEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public AlertMessageEntity setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public AlertMessageEntity setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
        return this;
    }

    @Override
    public String toString() {
        return "AlertMessageEntity{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", traceKey='" + traceKey + '\'' +
                ", traceMobile='" + traceMobile + '\'' +
                ", timeSpent=" + timeSpent +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", sourceIp='" + sourceIp + '\'' +
                '}';
    }
}
