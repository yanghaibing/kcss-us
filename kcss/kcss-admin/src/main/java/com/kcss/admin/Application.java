package com.kcss.admin;

import com.kcss.admin.config.AdminConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AdminConfig.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
