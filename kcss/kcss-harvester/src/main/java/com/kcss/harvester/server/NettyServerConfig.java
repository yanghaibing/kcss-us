package com.kcss.harvester.server;

import com.kcss.harvester.handler.ProspectorChannelInitializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:nettyserver.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file://${CONFIG_HOME}/kcss/harvester/nettyserver.properties", ignoreResourceNotFound = true)
})
public class NettyServerConfig {

    @Value("${tcp.port}")
    private int tcpPort;

    @SuppressWarnings("unchecked")
    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
        return new ServerBootstrap().group(parentGroup(), childGroup())
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(prospectorChannelInitializer);
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup parentGroup() {
        return new NioEventLoopGroup();
    }

    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup childGroup() {
        return new NioEventLoopGroup();
    }

    @Bean
    public InetSocketAddress inetSocketAddress() {
        return new InetSocketAddress(tcpPort);
    }

    @Autowired
    @Qualifier("prospectorChannelInitializer")
    public ProspectorChannelInitializer prospectorChannelInitializer;

}
