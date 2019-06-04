package com.kcss.job.config.metric;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JobMetricMapper {

    @Insert("INSERT INTO T_JOB_METRIC(JOB_NAME, UUID, DURATION, START_TIME, END_TIME, STATUS, MESSAGE) " +
            " VALUES(#{jobName}, #{uuid}, #{duration}, #{startTime}, #{endTime}, #{status}, #{message}) ")
    int createJobMetric(com.kcss.job.config.metric.JobMetricEntity metricEntity);

}
