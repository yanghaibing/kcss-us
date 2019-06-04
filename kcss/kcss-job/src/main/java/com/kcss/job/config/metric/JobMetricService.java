package com.kcss.job.config.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobMetricService {

    @Autowired
    private JobMetricMapper jobMetricMapper;

    public void createJobMetric(JobMetricEntity metricEntity) {
        jobMetricMapper.createJobMetric(metricEntity);
    }

}
