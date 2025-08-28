package com.company.auditdemo.session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public final class ClientSession {
    private static final String KEY_CLIENT_IP = "clientIp";

    private ClientSession() {}

    public static void storeIp(String ip) {
        var attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null) {
            attrs.getRequest().getSession(true).setAttribute(KEY_CLIENT_IP, ip);
        }
    }

    public static String getIp() {
        var attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs != null && attrs.getRequest().getSession(false) != null) {
            Object v = attrs.getRequest().getSession(false).getAttribute(KEY_CLIENT_IP);
            return v instanceof String ? (String) v : null;
        }
        return null;
    }
}
