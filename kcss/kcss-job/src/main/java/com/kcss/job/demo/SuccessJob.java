package com.kcss.job.demo;

import com.kcss.job.BaseJob;
import com.kcss.job.config.metric.JobMetricKey;
import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SuccessJob implements BaseJob {

    private final Logger logger = LoggerFactory.getLogger(SuccessJob.class);

    @Override
    public void run() {
        logger.info("uuid: {}, success", MDC.get(JobMetricKey.JOB_UUID));
    }
}
