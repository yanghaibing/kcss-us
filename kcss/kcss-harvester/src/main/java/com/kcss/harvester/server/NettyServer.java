package com.kcss.harvester.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

import javax.annotation.PreDestroy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;

@Component
public class NettyServer {

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    private InetSocketAddress inetSocketAddress;

    private Channel channel;

    public void start() throws Exception {
        channel = serverBootstrap.bind(inetSocketAddress).sync().channel().closeFuture().sync().channel();
    }

    @PreDestroy
    public void teardown() {
        channel.close();
        channel.parent().close();
    }

}
