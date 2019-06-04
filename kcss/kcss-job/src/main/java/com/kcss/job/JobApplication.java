package com.kcss.job;

import com.kcss.job.config.JobConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JobConfig.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
