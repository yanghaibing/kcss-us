package com.kcss.harvester;

import com.kcss.harvester.config.CommonImportConfig;
import com.kcss.harvester.server.NettyServer;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CommonImportConfig.class})
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = app.run(args);
        NettyServer nettyServer = context.getBean(NettyServer.class);
        nettyServer.start();
    }

}
