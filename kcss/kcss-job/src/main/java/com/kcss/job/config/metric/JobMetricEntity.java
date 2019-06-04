package com.kcss.job.config.metric;

import java.util.Date;

public class JobMetricEntity {

    private long id;
    private String jobName;
    private long uuid;
    private long duration;
    private Date startTime;
    private Date endTime;
    private Status status;
    private String message;

    public long getId() {
        return id;
    }

    public JobMetricEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getJobName() {
        return jobName;
    }

    public JobMetricEntity setJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public long getUuid() {
        return uuid;
    }

    public JobMetricEntity setUuid(long uuid) {
        this.uuid = uuid;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public JobMetricEntity setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public JobMetricEntity setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public JobMetricEntity setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public JobMetricEntity setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public JobMetricEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public enum Status {
        SUCCESS, FAILED, WAITING
    }

}
