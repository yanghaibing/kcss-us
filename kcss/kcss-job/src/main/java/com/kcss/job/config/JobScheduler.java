package com.kcss.job.config;

import com.kcss.job.demo.Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
@EnableAsync
@EnableScheduling
public class JobScheduler implements SchedulingConfigurer {

    private final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    @Autowired
    private JobProperties jobProperties;

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        logger.info("Creating Task Executor");
        System.out.println(jobProperties);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(jobProperties.getSetting().getCorePoolSize());
        executor.setMaximumPoolSize(jobProperties.getSetting().getMaxPoolSize());
        return executor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        // 开启
        taskRegistrar.addCronTask(() -> demo.run(),jobProperties.getCron().getDemo());

    }

    @Autowired
    private Demo demo;

}
