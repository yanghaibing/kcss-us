package com.kcss.job.config.metric;

import com.kcss.core.admin.SystemAdmin;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Aspect
@Component
public class JobMetricAspect {

    private final Logger logger = LoggerFactory.getLogger(JobMetricAspect.class);

    @Autowired
    private JobMetricService jobMetricService;

    @Pointcut("within(com.kcss.job.BaseJob+) && execution(* run(..))")
    public void metricPointcut() {
    }

    @SuppressWarnings("unchecked")
    @Around("metricPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Date startTime, endTime;

        // begin
        long uuid = RandomUtils.nextLong();
        MDC.put(JobMetricKey.JOB_UUID, String.valueOf(uuid));
        MDC.put(JobMetricKey.JOB_ADMIN_ID, String.valueOf(SystemAdmin.SYSTEM_JOB_ADMIN_ID));

        startTime = new Date();
        JobMetricEntity metricEntity = new JobMetricEntity()
                .setJobName(className + "." + methodName + "()")
                .setStartTime(startTime)
                .setUuid(uuid);
        logger.info("{}.{}() job begin", className, methodName);
        try {
            // execute
            Object result = joinPoint.proceed();

            // after
            logger.info("{}.{}() job finish", className, methodName);
            endTime = new Date();

            // exit
            metricEntity.setEndTime(endTime).setDuration(endTime.getTime() - startTime.getTime()).setStatus(JobMetricEntity.Status.SUCCESS);
            jobMetricService.createJobMetric(metricEntity);

            return result;
        } catch (Throwable e) {
            logger.error("{}.{}() job fail, stacktrace: ", className, methodName, e);
            endTime = new Date();
            metricEntity.setEndTime(endTime).setDuration(endTime.getTime() - startTime.getTime()).setStatus(JobMetricEntity.Status.FAILED).setMessage(ExceptionUtils.getStackTrace(e));
            jobMetricService.createJobMetric(metricEntity);
            throw e;
        }
    }


}
