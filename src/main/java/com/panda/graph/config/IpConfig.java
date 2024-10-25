package com.panda.graph.config;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author muxiaohui
 */
public class IpConfig extends ClassicConverter {

    private static String webIP;

    static {
        try {
            webIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            webIP = "exception";
        }
    }

    @Override
    public String convert(ILoggingEvent event) {
        return webIP;
    }
}
